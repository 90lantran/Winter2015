package Testing;
/*
 * Given an array of elements which is first increasing 
 * and then decreasing, find the maximum element in the array.
 */
public class FindMax {
	
	private static int findMax(int[] arr, int low, int high){
		
		if (low == high){
			return low;
		}
		
		if (low == high - 1 && arr[low] >= arr[high]){
			return low;
		}else if (low == high - 1 && arr[low] < arr[high]){
			return high;
		}
		
		int middle = (low + high) / 2;
		
		if (arr[middle] > arr[middle -1] && arr[middle] > arr[middle +1]){
			return middle;
		}
		
		if(arr[middle] > arr[middle -1] &&  arr[middle] < arr[middle + 1]){
			return findMax(arr, middle +1, high);
		} else{
			return findMax(arr, low, middle -1);
		}
	}
	
	
	public static void main(String[] args){
		int[] arr ={1,15,25, 45, 42, 21, 17, 12, 11};
		
		System.out.println(findMax(arr, 0, arr.length -1));
		
		
		
		
		
	}

}
