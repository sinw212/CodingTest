
public class 머쓱이보다키큰사람 {
	public static void main(String args[]) {
		Solution머쓱이보다키큰사람 s = new Solution머쓱이보다키큰사람();
		int[] array = {149, 180, 192, 170};
		System.out.println(s.solution(array, 167));
	}
}

class Solution머쓱이보다키큰사람 {
	public int solution(int[] array, int height) {
		int answer = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] > height) {
				answer++;
			}
		}
		return answer;
	}
}