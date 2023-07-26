//import java.util.Arrays;

public class 배열두배만들기 {
	public static void main(String args[]) {
		Solution배열두배만들기 s = new Solution배열두배만들기();
		int[] numbers = new int[] {1,2,3,4,5};
		int[] res = s.solution(numbers);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution배열두배만들기 {
	public int[] solution(int[] numbers) {
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = numbers[i]*2;
		}
		return numbers;
	}
}
