
public class 행렬의덧셈 {
	public static void main(String args[]) {
		Solution행렬의덧셈 s = new Solution행렬의덧셈();
		int[][] arr1 = {{1, 2}, {2, 3}};
		int[][] arr2 = {{3, 4}, {5, 6}};
		int[][] res = s.solution(arr1, arr2);
		for(int i=0; i<res.length; i++) {
			for(int j=0; j<res[i].length; j++) {
				System.out.print(res[i][j] + ", ");
			}
			System.out.println();
		}
	}
}

class Solution행렬의덧셈 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[0].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}
}