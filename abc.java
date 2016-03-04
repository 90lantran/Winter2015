import java.util.Iterator;


public class abc {

	public static int countNumber(int x){
		int count = 0;
		if (x == 0) return 0;
		if (x< 0) x = 0 - x;
		while(x > 0){
			count++;
			x = x /10;
		}
		
		
		return count;
	}
	
	public static int[] reverseOrder(int[] input){
		for(int i = 0; i < input.length/2; i++){
			int temp = input[i];
			input[i] = input[input.length - i -1];
			input[input.length -i -1] = temp;
		}
		
		
		return input;
	}
	
	public static int[] removeElement(int[] input, int index){
		int[] result = new int[input.length -1];
		int i;
		for(i = 0; i < index ; i++){
			result[i] = input[i];
		}
		
		for(int j = index + 1; j < input.length; j++){
			result[i++] = input[j];
		}
		
		
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(countNumber(2));
		System.out.println(countNumber(1000));
		System.out.println(countNumber(-210));
		System.out.println(countNumber(-222210));
		System.out.println(countNumber(-10010));
		System.out.println(countNumber(-1));
		
		
		int[] arr = {1,2,3,4,5};
//		arr = reverseOrder(arr);
		arr = removeElement(arr, 3);
		for(int i : arr){
			System.out.println(i);
		}
		
		//arr = removeElement(arr, 3);
		
	}
}
