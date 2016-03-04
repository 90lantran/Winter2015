
public class countGreaterThan {
	
	public static<T extends myInterface<T>> int count(T[] anArray, T element){
		int count = 0; 
		for (T e : anArray){
			if (e.compareTo(element) > 0){
				count++;
			}
		}
		return count;
	}
	
	
}
