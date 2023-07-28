import java.util.Arrays;

public class 문자열정렬하기2 {
	public static void main(String args[]) {
		Solution문자열정렬하기2 s = new Solution문자열정렬하기2();
		System.out.println(s.solution("Bcad"));
	}
}

class Solution문자열정렬하기2 {
	public String solution(String my_string) {
//		String answer = "";
//		
//		String str[] = new String[my_string.length()];
//		for(int i=0; i<my_string.length(); i++) {
//			char c = my_string.charAt(i);
//			str[i] = String.valueOf(Character.toLowerCase(c));
//		}
//		Arrays.sort(str);
//		for(String s: str) {
//			answer += s;
//		}
//		return answer;
		
		char[] c = my_string.toLowerCase().toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
