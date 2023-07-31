
public class 이차원으로만들기 {
	public static void main(String args[]) {
		Solution이차원으로만들기 s = new Solution이차원으로만들기();
		int[] num_list = {1,2,3,4,5,6,7,8};
		int[][] res = s.solution(num_list, 2);
		for(int i=0; i<res.length; i++) {
			System.out.print("[");
			for(int j=0; j<res[i].length; j++) {
				System.out.print(res[i][j] + ",");
			}
			System.out.print("],");
		}
	}
}

class Solution이차원으로만들기 {
	public int[][] solution(int[] num_list, int n) {
		int[][] answer = new int[num_list.length/n][n];
//		int count = 0;
//		for(int i=0; i<answer.length; i++) {
//			for(int j=0; j<answer[i].length; j++) {
//				answer[i][j] = num_list[count];
//				count++;
//			}
//		}
		for(int i=0; i<num_list.length; i++) {
			answer[i/n][i%n] = num_list[i];
		}
		return answer;
	}
}