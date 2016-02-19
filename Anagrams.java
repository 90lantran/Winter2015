
public class Anagrams {
	
	static void findAllCombinations(String s){
		findAllCombinations(s, 0, s.length()-1);
	}
	
	static String swap(String s, int index1, int index2){
		char[] arr = s.toCharArray();
		char temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		
		return s = new String(arr);
	}
	
	static void findAllCombinations(String s, int start, int end){
		if (start == end){
			System.out.println(s);
			return;
		}
		for(int i = start; i < s.length(); i++ ){
			//String temp = new String(s);
			String temp = swap(s,i,start);
			findAllCombinations(temp, start + 1, end);
			
		}
	}
	
	public static void main(String[] args) {
		findAllCombinations("abc");

	}

}
