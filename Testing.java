import static org.junit.Assert.*;

import org.junit.Test;


public class Testing {

	@Test
	public void testMedianTwoSorted() {
		
		int[] one ={3,5,7,8,11};
		int[] two = {4,6,9,10,11,11};
				
		int median = MedianTwoSortedArray.findMedian(one, two);
		
		assertTrue(median == 8);
		//fail("Not yet implemented");
	}

}
