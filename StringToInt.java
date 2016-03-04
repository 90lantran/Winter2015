import java.util.Scanner;

public class StringToInt {
	static boolean flag = true;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		processing(input);
	}
	
	static void processing(String input){
		int result = 0;
		if (input != null) {
			char[] charArr = input.toCharArray();
			char firstChar = charArr[0];
			
			if (firstChar == '-'){
				result = convertToInt(1, charArr);
				if (flag)
				System.out.println(0 - result);
			} else if (firstChar == '+' ){
				result = convertToInt(1, charArr);
				if (flag)
				System.out.println(result);
			} else if (Character.isDigit(firstChar)){
				result = convertToInt(0, charArr);
				if(flag)
				System.out.println(result);
			} else {
				System.out.println("Invalid input");
			}
				
				
				
		
		}
	}
	
	static int convertToInt(int start,char[] charArr){
		int result = 0;
		//int index = 0;
		for (int i = start; i < charArr.length; i++) {
			
			if (!Character.isDigit(charArr[i])){
				System.out.println("Invalid input");
				//result = Integer.MAX_VALUE;
				flag = false;
				break;
			} else {
				int newResult = (int) ((charArr[i] - '0') + result*10);
				if (newResult < result){
					System.out.println("Overflow");
					//result = Integer.MAX_VALUE;
					flag = false;
					break;
				} else {
					result = newResult;
				}
			}
		}
		return result;
	}

}
