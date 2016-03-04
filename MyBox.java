import java.util.ArrayList;
import java.util.List;



public class MyBox<T> {

	private List<T> list = new ArrayList<T>();
	private T t;
	public void set(T t){
		this.t = t;
	}
	public T get(){
		return t;
	}
	
	public static void main(String[] args){
		MyBox<Integer> intBox = new MyBox<>();
		intBox.list.add(3);
		
	}
}
