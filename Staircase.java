import java.util.Scanner;


public class Staircase {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = n - 1; i >= 0; i--){
        	
        		printSpaces(i);
        		print(n - i);
        	
        	System.out.println("");
        }
        in.close();
	}
	
	static void printSpaces(int num){
		for(int i = 0 ; i < num; i++){
			System.out.print(" ");
		}
	}
	
	static void print(int num){
		for(int i = 0; i < num; i++){
			System.out.print("#");
		}
	}
	
}
