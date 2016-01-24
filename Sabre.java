import java.util.Stack;

public class Sabre {
	private int number;

	public static void main(String[] args) {
		System.out.println(braces("[]{}()"));

		System.out.println(braces("[{]{}()]"));

	}

	static String braces(String value) {
		if (value == null || value.length() == 0)
			return "NO";
		Stack<Character> stack = new Stack<>();
		int len = value.length();
		for (int i = 0; i < len; i++) {
			Character currentCharacter = value.charAt(i);
			if (currentCharacter == '(' || currentCharacter == '{'
					|| currentCharacter == '[')
				stack.push(currentCharacter);
			else if (!stack.isEmpty()) {
				Character charInStack = stack.pop();
				if ((currentCharacter == ')' && charInStack == '(')
						|| (currentCharacter == '}' && charInStack == '{')
						|| (currentCharacter == ']' && charInStack == '['))
					continue;
				else
					return "NO";
			} else if (stack.isEmpty())
				return "NO";
		}
		return stack.isEmpty() == true ? "YES" : "NO";
	}

//	static String braces(String value) {
//		Stack<Character> s = new Stack<Character>();
//
//		if (value != null && value.length() > 0) {
//			s.push(value.charAt(0));
//			for (int i = 0; i < value.length() - 1; i++) {
//				if (s.size() == 0)
//					s.push(value.charAt(i));
//				System.out.println("Top of stack " + s.peek());
//				System.out.println("In value " + value.charAt(i + 1));
//				char c = value.charAt(i + 1);
//				switch (s.peek()) {
//				case '{':
//					if (c == '}') {
//						System.out.println("Match");
//						s.pop();
//						i++;
//					}
//					break;
//				case '[':
//					if (c == ']') {
//						System.out.println("Match");
//						s.pop();
//						i++;
//					}
//					break;
//
//				case '(':
//					if (c == ')') {
//						s.pop();
//						System.out.println("Match");
//						i++;
//					}
//					break;
//				default:
//					// s.push(c);
//				}
//
//			}
//
//			return s.size() == 0 ? "YES" : "NO";
//		} else {
//			return "NO";
//		}
//	}

}
