import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	static int[] findTwoSum(int[] numbers, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		
		for(int i = 0; i < numbers.length; i++){
			if(map.containsKey(numbers[i])){
				result[0] = i + 1;
				result[1] = map.get(numbers[i]);
			}else {
				map.put(target - numbers[i], i+1);
			}
		}
		
			
			
			return result;
	}
	public static void main(String[] agrs) {
		int[] numbers = {2,7,11,15};
		int target = 9;
		
		int[] result = findTwoSum(numbers, target);
		for(int i : result){
			System.out.println(i);
		}
	}
}
