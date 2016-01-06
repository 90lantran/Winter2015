
public class MinPathSum {

	public static void main(String[] args) {
		// /*this is a // // comment */
		int[][] grid = {{8,2,0,0}, {1,1,1,1}, {4,7,8,2}};
		int[][] m = new int[grid.length][grid[0].length];
		
		int runningSum = 0;
		for(int j = 0; j < grid[0].length; j++){
			m[0][j] = runningSum + grid[0][j];
			runningSum = m[0][j];					
		}
		
		runningSum = 0;
		for(int i = 0; i < grid.length; i++){
			m[i][0] = runningSum + grid[i][0];
			runningSum = m[i][0];					
		}
		
		
		for(int i = 1; i < m.length; i++){
			for(int j = 1; j < m[0].length; j++){
				m[i][j] = Math.min(m[i][j-1] + grid[i][j],m[i-1][j] + grid[i][j]);
			}
		}
		
		System.out.println(m[2][3]);
		
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[0].length; j++){
				System.out.print( m[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

}
