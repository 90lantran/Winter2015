import java.util.Stack;


public class ReverseString {
	
	public static String reverseString(String s){
		String r = "";
		
		 r =reverseStringHelper(s, r, s.length() -1);
		return r;
	}
	
	private static String reverseStringHelper(String s, String r, int count){
		
		if (count >= 0){
			r = reverseStringHelper(s, r+s.charAt(count), --count);
		}
		
		return r;
	}
	
	
	public static String reverseSentence(String line){
		String result ="";
		String[] arr = line.split(" ");
		Stack<String> stack = new Stack<>();
		for (String x: arr) stack.push(x);
		
		while(!stack.isEmpty()){
			result += stack.pop() + " ";
		}
		result.trim();
		
		if (result.trim().length() == line.length()) System.out.println("Same length");
		return result;
	}
	
	
	public static void main(String[] args){
		System.out.println(reverseString("abcdef"));
		System.out.println(reverseSentence("I love you"));
	}
}
