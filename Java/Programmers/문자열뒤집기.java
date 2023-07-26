
public class 문자열뒤집기 {
	public static void main(String args[]) {
		Solution문자열뒤집기 s = new Solution문자열뒤집기();
		System.out.println(s.solution("jaron"));
	}
}

class Solution문자열뒤집기 {
	public String solution(String my_string) {
		return new StringBuilder(my_string).reverse().toString();
	}
}