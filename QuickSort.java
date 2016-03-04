
public class QuickSort {
	public int partition(int[] input, int p , int r){
		int i = p -1;
		int pivot = input[r];
		
		for(int j = p; j < r ; j++){
			if(input[j] <= pivot){
				i++;
				swap(input, j , i);
			}
		}
		
		i++;
		
		swap(input, i, r);
		
		return i;
		
		
		
		
	}
	
	public void swap(int[]arr, int j, int i){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sort(int[] input, int q,int r){
		if(q < r){
			int pivot = partition(input, q, r);
			sort(input, q, pivot -1);
			sort(input, pivot +1, r);
		}
	}
	public static void main(String[] args){
		int[] input ={10,7,8,9,1,5};
		QuickSort qs = new QuickSort();
		System.out.println(qs.partition(input, 0, input.length -1));
		
		qs.sort(input,0, input.length -1);
		for(int x: input){
			System.out.print(x + " ");
		}
	}
}
