
public class 없는숫자더하기 {
	public static void main(String args[]) {
		Solution없는숫자더하기 s = new Solution없는숫자더하기();
		System.out.println(s.solution(new int[] {1,2,3,4,6,7,8,0}));
	}
}

class Solution없는숫자더하기 {
	public int solution(int[] numbers) {
		int answer = 0;
		int[] number = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		for(int i=0; i<numbers.length; i++) {
			number[numbers[i]]++;
		}
		for(int i=0; i<number.length; i++) {
			if(number[i] == 0) {
				answer += i;
			}
		}
		return answer;
		
//		int sum = 45;
//		for(int i : numbers) {
//			sum -= i;
//		}
//		return sum;
	}
}