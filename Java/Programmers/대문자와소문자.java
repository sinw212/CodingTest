
public class 대문자와소문자 {
	public static void main(String args[]) {
		Solution대문자와소문자 s = new Solution대문자와소문자();
		System.out.println(s.solution("abCdEfghIJ"));
	}
}

class Solution대문자와소문자 {
	public String solution(String my_string) {
		String answer = "";
		for(int i=0; i<my_string.length(); i++) {
			char c = my_string.charAt(i);
			if(Character.isUpperCase(c)) {
				answer += String.valueOf(c).toLowerCase();
			} else if(Character.isLowerCase(c)) {
				answer += String.valueOf(c).toUpperCase();
			}
		}
		return answer;
	}
}