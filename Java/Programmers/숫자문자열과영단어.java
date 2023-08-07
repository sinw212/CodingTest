
public class 숫자문자열과영단어 {
	public static void main(String args[]) {
		Solution숫자문자열과영단어 s = new Solution숫자문자열과영단어();
		System.out.println(s.solution("one4seveneight"));
	}
}

class Solution숫자문자열과영단어 {
	public int solution(String s) {
		String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		for(int i=0; i<numbers.length; i++) {
			s = s.replaceAll(numbers[i], String.valueOf(i));
		}
		return Integer.parseInt(s);
	}
}