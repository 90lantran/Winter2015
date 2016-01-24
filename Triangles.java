import java.util.Scanner;


public class Triangles {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] input = new int[n][3];
		for(int i = 0; i < n; i++ ){
			for(int j = 0; j < 3; j++){
				input[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++ ){
			
			int side1 =	input[i][0];
			int side2 = input[i][1];
			int side3 = input[i][2];
			
			if (side1 == side2 && side2 == side3){
				System.out.println("Equilateral");
			} else if(side1 == side2 || side1 == side3){
				System.out.println("Isoceles");
			} else {
				System.out.println("None of these");
			}
			
		}
		
	}
}
