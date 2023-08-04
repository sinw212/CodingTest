import java.util.Arrays;

public class 문자열내마음대로정렬하기 {
	public static void main(String args[]) {
		Solution문자열내마음대로정렬하기 s = new Solution문자열내마음대로정렬하기();
		String[] strings = {"abce", "abcd", "cdx"};
		String[] res = s.solution(strings, 1);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		for(int i=0; i<strings.length; i++) {
			answer[i] = String.valueOf(strings[i].charAt(n))+strings[i];
		}
		Arrays.sort(answer);
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = answer[i].substring(1, answer[i].length());
		}
		return answer;
	}
}