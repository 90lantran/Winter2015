import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

	public class Word {
		int count = 1;
		String word;


		public Word(String word) {
			this.word = word;
		}

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

	}

	public int trace(String start, String end, List<String> dict) {
		dict.add(end);
		Queue<Word> toExplore = new LinkedList<>();
		HashSet<Word> visited = new HashSet<Word>();
		Map<String, String> parentMap = new HashMap<>();
		Word begin = new Word(start);
		Word goal = new Word(end);
		
		boolean found = false;

		toExplore.add(begin);
		visited.add(goal);
		while (!toExplore.isEmpty()) {

			Word curr = toExplore.remove();
			//System.out.println("Out of the queue: " + curr.getWord());
			// StringBuilder alias = new StringBuilder(curr);
			if (curr.getWord().equals(end)){
				found = true;			
				//return curr.getCount(); // if want to optimize, uncomment this one
			}
					
			for (int i = 0; i < curr.getWord().length(); i++) {
				String currString = curr.getWord();
				for (char c = 'a'; c <= 'z'; c++) {
					
					char currentChar = currString.charAt(i);
					String tempString = currString.replace(currentChar, c);
					Word tempWord = new Word(tempString);
					
					
					if (!visited.contains(tempWord) && dict.contains(tempString)) {
						Word next = new Word(tempString, curr.getCount() +1);
						visited.add( next);
						toExplore.add(next );
						parentMap.put(tempString, curr.getWord());
						//System.out.println("Add to the queue " + tempString);
						dict.remove(tempString);
					}
				}
			}
			
		}
		
		if (!found) {
			System.out.println("No path exists");
			return 0;
		}
		// reconstruct the path
		LinkedList<String> path = new LinkedList<String>();
		String curr = end;
		while (!curr.equals(start)) {
			path.addFirst(curr);
			curr = parentMap.get(curr);
		}
		path.addFirst(start);
		for(String s:path){
			System.out.println(s);
		}

		return path.size();
	}

	public static void main(String[] args) {
		List<String> dict = new ArrayList<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		String start = "hit";
		String end ="cog";
		
		WordLadder wl = new WordLadder();
		System.out.println(wl.trace(start, end, dict));
		
	}

}
