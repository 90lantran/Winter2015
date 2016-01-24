import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
	
	public static final int SIZE = 100;
	private static int[][] readInput() {

		int[][] input = new int[SIZE][SIZE];
		FileInputStream fis;
		int i = 0;
		try {
			fis = new FileInputStream(new File("src/data.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String l = null;
			while ((l = br.readLine()) != null) {
				String[] temp;

				if (l.contains(" ")) {
					temp = l.split(" ");
				} else {
					temp = new String[1];
					temp[0] = l;
				}
				int index = 0;
				for (int j = i; j >= 0; j--) {

					input[j][i - j] = Integer.parseInt(temp[index++]);
				}
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cannot find data.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cannot read file.");
		}
		return input;
	}

	private static int path() {
		int[][] input = readInput();

		int[][] sum = new int[SIZE][SIZE];
		sum[0][0] = input[0][0];
		for (int i = 1; i < SIZE; i++) {
			sum[i][0] = sum[i - 1][0] + input[i][0];
		}

		for (int j = 1; j < SIZE; j++) {
			sum[0][j] = sum[0][j - 1] + input[0][j];
		}

		for (int i = 1; i < SIZE; i++) {
			for (int j = 1; j < SIZE; j++) {
				sum[i][j] = input[i][j]
						+ Math.max(sum[i - 1][j], sum[i][j - 1]);
			}
		}
		int currentMax = 0;
		for (int i = 0; i < SIZE; i++) {
			if (currentMax < sum[i][SIZE - 1 - i]) {
				currentMax = sum[i][SIZE -1 - i];
			}
		}

		return currentMax;
	}

	public static void main(String[] args) {

		System.out.println(path());

	}

}
