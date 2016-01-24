import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] a = new int[T];
		int[] b = new int[T];
		int[] N = new int[T];
		for (int i = 0; i < T; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			N[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < T; i++) {
			int result = 0;
			result = a[i] + b[i];
			System.out.print(result);
			for (int j = 1; j < N[i]; j++) {
				result = result + (int) Math.pow(2, j) * b[i];
				System.out.print(" " + result);
			}
			System.out.println("");
		}
		sc.close();

	}
}
