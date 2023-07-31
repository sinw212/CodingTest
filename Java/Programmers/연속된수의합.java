
public class 연속된수의합 {
	public static void main(String args[]) {
		Solution연속된수의합 s = new Solution연속된수의합();
		int[] res = s.solution(4,  14);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution연속된수의합 {
	public int[] solution(int num, int total) {
		int chuk = (total/num) - ((num-1)/2);
		int[] answer = new int[num];
		for(int i=0; i<num; i++) {
			answer[i] = chuk++;
		}
		return answer;
	}
}