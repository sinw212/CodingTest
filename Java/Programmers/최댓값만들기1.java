import java.util.Arrays;

public class 최댓값만들기1 {
	public static void main(String args[]) {
		Solution최댓값만들기1 s = new Solution최댓값만들기1();
		int[] numbers = new int[] {0, 31, 24, 10, 1, 9};
		System.out.println(s.solution(numbers));
	}
}

class Solution최댓값만들기1 {
	public int solution(int[] numbers) {
		Arrays.sort(numbers);
		return numbers[numbers.length-1] * numbers[numbers.length-2];
	}
}