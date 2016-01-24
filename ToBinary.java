import java.util.Scanner;
import java.util.Stack;


public class ToBinary {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		for (int i = 0; i < N ; i++){
			input[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++){
			int x = input[i];
			if ( x == 0) {
				System.out.println("0");
				return;
			}
			String result = "";
			Stack<Integer> s = new Stack<Integer>();
			while( x > 0){
				int r  = x %2;
				s.push(r);
				x = x/2;
			}
			while(!s.isEmpty()){
				result = result + s.pop();
			}
			System.out.println(result);
		}
		
		sc.close();
	}

}
