


public class fizzbuzz {
	public static void main(String[] args){
//		for (int i = 0; i < 100; i++){
//			int x = i %3;
//			int y = i %5;
//			if (x == 0 && y == 0){
//				System.out.println(i + " fizzbuzz");
//			}else if (x == 0){
//				System.out.println(i + " fizz");
//			}else if (y == 0){
//				System.out.println(i + " buzz");
//			}
//		}
//		
		for (int i = 0; i < 100; i++){
			if (i % 3 == 0)
				System.out.print("fizz");
			if (i %5 == 0)
				System.out.print("buzz");
			System.out.println( " " + i);
		}
		
		System.out.println(reverseNumber(123456));
		
	}
	
//	public static int reverseNumber(int x){
//		int result=0;
//		while (true){
//			int last = x %10;
//			result = result*10 + last;
//			x = x/10;
//			if (x < 1){
//				break;
//			}
//		}
//		
//		return result;
//	}
	
	public static int reverseNumber(int x){
		return reverseNumber(x,0);
	}
	
	public static int reverseNumber(int x, int y){
		if (x < 1){
			return y;
		} else {
			y = y *10 + x %10;
			x = x/10;
			return reverseNumber(x, y);
		}
		
	}
}
