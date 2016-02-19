import java.util.Scanner;


public class MaxSubArray {
	static int maxSubArray(int[] arr){
		for (int i = 0; i < arr.length ; i++){
			if (arr[i] == 0) arr[i] = Integer.MIN_VALUE;
		}
		
		int currentMax = 0;
		int runningSum = 0;
		
		for(int i = 0; i < arr.length; i++){
			runningSum = Math.max(0, runningSum + arr[i]);
			currentMax = Math.max(currentMax, runningSum);
		}
		
		return currentMax;
	}
	
//	static int maxSubArray(int[] arr){
//		
//		int currentMax = 0;
//		
//		int runningSum = 0;
//		for(int i = 0; i < arr.length; i++){
//			if (arr[i] != 0){
//				runningSum += arr[i];
//				currentMax = currentMax >= runningSum ? currentMax : runningSum;
//			} else {
//				runningSum = 0;
//				
//			}
//		}
//		return currentMax;
//	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}

		System.out.println(maxSubArray(arr));
	}
}
