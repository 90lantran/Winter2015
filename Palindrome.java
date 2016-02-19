
public class Palindrome {
	static boolean isPalindrome(String s){
		return isPalindrome(s, 0, s.length() -1) ;
	}
	
	static boolean isPalindrome(String s, int index1, int index2){
		if (index1 == index2 || ((index2 - index1 == 1)&&
				s.charAt(index1) == s.charAt(index2))){
			return true;
		}
		if (s.charAt(index1) != s.charAt(index2)){
			return false;
		}else{
			return isPalindrome(s, index1 + 1, index2-1);
		}
	
	}
	public static void main(String[] args) {
	System.out.println(isPalindrome("abca"));

	}

}
