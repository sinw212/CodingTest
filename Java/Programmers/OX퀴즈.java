import java.util.StringTokenizer;

public class OX퀴즈 {
	public static void main(String args[]) {
		SolutionOX퀴즈 s = new SolutionOX퀴즈();
		String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
		String[] res = s.solution(quiz);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class SolutionOX퀴즈 {
	public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];
		for(int i=0; i<quiz.length; i++) {
//			StringTokenizer st = new StringTokenizer(quiz[i], " ");
//			int x = Integer.parseInt(st.nextToken());
//			String operator = st.nextToken();
//			int y = Integer.parseInt(st.nextToken());
//			String equalsOp = st.nextToken();
//			if(operator.equals("+")) {
//				answer[i] = Integer.parseInt(st.nextToken()) == x+y ? "O" : "X"; 
//			} else {
//				answer[i] = Integer.parseInt(st.nextToken()) == x-y ? "O" : "X";
//			}
			String splitArr[] = quiz[i].split(" ");
			int result = Integer.parseInt(splitArr[0]) + ((splitArr[1].equals("+") ? 1 : -1) * (Integer.parseInt(splitArr[2])));
			answer[i] = result == Integer.parseInt(splitArr[4]) ? "O" : "X";
		}
		return answer;
	}
}