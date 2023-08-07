import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
	public static void main(String args[]) {
		Solution나누어떨어지는숫자배열 s = new Solution나누어떨어지는숫자배열();
		int[] res = s.solution(new int[] {5, 9, 7, 10}, 5);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution나누어떨어지는숫자배열 {
	public int[] solution(int[] arr, int divisor) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % divisor == 0) {
				count++;
			}
		}
		if(count == 0) {
			return new int[]{-1};
		}
		
		int[] answer = new int[count];
		int n = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % divisor == 0) {
				answer[n++] = arr[i];
			}
		}
		Arrays.sort(answer);
		return answer;
	}
}