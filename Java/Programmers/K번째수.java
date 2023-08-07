import java.util.Arrays;

public class K번째수 {
	public static void main(String args[]) {
		SolutionK번째수 s = new SolutionK번째수();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] res = s.solution(array, commands);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class SolutionK번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
//		int[] subArray = {};
		
		for(int i=0; i<commands.length; i++){
//			subArray = new int[commands[i][1]-commands[i][0]+1];
//			int n = 0;
//			for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++) {
//				subArray[n] = array[j];
//				n++;
//			}
			int[] subArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(subArray);
			answer[i] = subArray[commands[i][2]-1];
		}
		return answer;
	}
}