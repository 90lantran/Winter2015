import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IsomorphicString {
	public static boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++){
			char fromS = s.charAt(i);
			char fromT = t.charAt(i);
			
			if ( map.containsValue(fromT)){
				if (map.get(fromS) != fromT){
					return false;
				}
			} else {
				map.put(fromS, fromT);
			}
			
			
		}
		return true;
//		Map<Character, Integer> mapS = getStructure(s);
//		Map<Character, Integer> mapT = getStructure(t);
//		if (mapT.size() == mapS.size()) {
//			for (Entry<Character, Integer> entry : mapS.entrySet()) {
//				if (!mapT.containsValue(entry.getValue())) {
//					return false;
//				}
//			}
//		} else {
//			return false;
//		}
//
//		return true;

	}

	private static Map<Character, Integer> getStructure(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		return map;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("doo", "gmm"));
	}
}
