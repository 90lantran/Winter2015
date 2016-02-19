import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Roman2Int {

	private static Map<String, Integer> lookUp = new HashMap<String, Integer>();

	static void initialize() {
		lookUp.put("I", new Integer(1));
		lookUp.put("V", new Integer(5));
		lookUp.put("X", new Integer(10));
		lookUp.put("L", new Integer(50));
		lookUp.put("C", new Integer(100));
		lookUp.put("D", new Integer(500));
		lookUp.put("M", new Integer(1000));
		lookUp.put("IV", new Integer(4));
		lookUp.put("IX", new Integer(9));
		lookUp.put("XL", new Integer(40));
		lookUp.put("XC", new Integer(90));
		lookUp.put("CD", new Integer(400));
		lookUp.put("CM", new Integer(900));

	}

	static int roman2Int(String roman) {
		int result = 0;
		String[] arr = roman.split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("I") && (i+1) < arr.length && arr[i+1].equals("V")) {
				result += lookUp.get("IV");
				i++;
			} else if (arr[i].equals("I")&& (i+1) < arr.length && arr[i+1].equals("X")) {
				result += lookUp.get("IX");
				i++;
			} else if (arr[i].equals("X")&& (i+1) < arr.length &&arr[i+1].equals("L")) {
				result += lookUp.get("XL");
				i++;
			} else if (arr[i].equals("X")&& (i+1) < arr.length &&arr[i+1].equals("C")) {
				result += lookUp.get("XC");
				i++;
			} else if (arr[i].equals("C")&& (i+1) < arr.length &&arr[i+1].equals("D")) {
				result += lookUp.get("CD");
				i++;
			} else if (arr[i].equals("C")&& (i+1) < arr.length &&arr[i+1].equals("M")){
				result += lookUp.get("CM");
				i++;
			} else {
				result += lookUp.get(arr[i]);
			}

		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String roman = sc.nextLine();
		initialize();
		System.out.println(roman2Int(roman));
	}
}
