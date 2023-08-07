
public class 두정수사이의합 {
	public static void main(String args[]) {
		Solution두정수사이의합 s = new Solution두정수사이의합();
		System.out.println(s.solution(3, 3));
	}
}

class Solution두정수사이의합 {
	public long solution(int a, int b) {
		long answer = 0;
		for(int i=(a < b ? a : b); i<=(a < b ? b : a); i++) {
			answer += i;
		}
		return answer;
	}
}