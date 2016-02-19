import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;



public class HappyNumber {
	public static final int NUM = 2;
	
	static void isHappy(int n, Stack<Integer> s){
		List<Integer> digits = arrayDigits(n);
		//Stack<Integer> s = new Stack<Integer>();
		int newNum = getNewNum(digits);
		if (newNum == 1){
			System.out.println("happy "+ s.pop());
			return;
		}else if (s.contains(newNum)){
			System.out.println("unhappy " + (s.size() +1));
			return;
		} else {
			s.push(newNum);
			isHappy(newNum, s);
		}
		
	}
	static int getNewNum(List<Integer> digits){
		int sum = 0;
		for (int i = 0; i < digits.size(); i++){
			sum = sum + digits.get(i)*digits.get(i);
			//System.out.println(sum);
		}	
		
		return sum;
	}
	
	
	
	static List<Integer> arrayDigits(int n){
		int numDigits = (int) Math.log10(n) + 1;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < numDigits; i++){
			int temp = n%10;
			list.add(temp);
			//System.out.println("----" + temp);
			n = n/10;
		}
		
		return  list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[NUM];
		for(int i = 0; i < NUM; i++){
			input[i] = sc.nextInt();
		}
		
		for(int i = 0; i < NUM; i++){
			isHappy(input[i], new Stack<Integer>());
		}

	}

}
