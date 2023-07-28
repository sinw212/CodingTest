
public class 이진수더하기 {
	public static void main(String args[]) {
		Solution이진수더하기 s = new Solution이진수더하기();
		System.out.println(s.solution("10", "11"));
	}
}

class Solution이진수더하기 {
	public String solution(String bin1, String bin2) {
		return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
	}
}
