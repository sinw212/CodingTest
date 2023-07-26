
public class 배열뒤집기 {
	public static void main(String args[]) {
		Solution배열뒤집기 s = new Solution배열뒤집기();
		int[] num_list = new int[] {1, 2, 3, 4, 5};
		int[] res = s.solution(num_list);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution배열뒤집기 {
	public int[] solution(int[] num_list) {
		int answer[] = new int[num_list.length];
		for(int i=0; i<num_list.length; i++) {
			answer[num_list.length-1-i] = num_list[i];
		}
		return answer;
	}
}