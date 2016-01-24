import java.util.Stack;

public class RPN {

	static boolean isValid(String[] tokens) {
		String regex = "[\\+-]?\\d+|\\+|-|/|\\*";
		for (String s : tokens) {
			if (!s.matches(regex))
				return false;
		}

		return true;
	}

	static int calculateRPN(String[] input) {
		Stack<Integer> s = new Stack<Integer>();
		if (isValid(input)) {
			for (String op : input) {
				switch (op) {
				case "*":
					if (s.size() >= 2) {
						s.push(s.pop() * s.pop());
						break;
					} else {
						System.out.println("Error when doing multipilcation.");
						return Integer.MIN_VALUE;
					}
					
				case "-":
					if (s.size() >= 2) {
						s.push(s.pop() - s.pop());
						break;
					} else {
						System.out.println("Error when doing multipilcation.");
						return Integer.MIN_VALUE;
					}
				
				case "+":
					if (s.size() >= 2) {
						s.push(s.pop() + s.pop());
						break;
					} else {
						System.out.println("Error when doing multipilcation.");
						return Integer.MIN_VALUE;
					}
				
				case "/":
					if (s.size() >= 2) {
						int op1 = s.pop();
						int op2 = s.pop();
						if (op2 != 0) {
							s.push(op1 / op2);
							break;
						} else {
							throw new ArithmeticException();
						}
					} else {
						System.out.println("Error when doing division.");
						return Integer.MIN_VALUE;
					}
		
				default:
					s.push(Integer.parseInt(op));
				}

			}

		}

		return s.peek();

	}

	public static void main(String[] args) {
		String[] input = { "-", "5","*", "+" };
		
		System.out.println("Result of calculation: " + calculateRPN(input)
				+ ".");


	}

}
