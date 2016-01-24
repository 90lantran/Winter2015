
public class MedianTwoSortedArray {
	
	static int findMedian(int[] one, int[] two){
		int median = (one.length + two.length - 1)/2;
		
		int p1 = 0; 
		int p2 = 0;
		
		//int l = one.length > two.length ? one.length : two.length;
		for(int i = 0; i < median; i++){
			if (one[p1] >= two[p2]){
				p2++;
				System.out.println(p2);
			} else {
				p1++;
				System.out.println(p1);
			}
		}
		
		
		if (one[p1] >= two[p2]){
			return two[p2];
		}else {
			return one[p1];
		}
	}
	
	public static void main(String[] args) {
		int[] one ={3,5,7,8,11};
		int[] two = {4,6,9,10,11,11};
		System.out.println(findMedian(one, two));
	}

}
