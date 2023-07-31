
public class n의배수고르기 {
	public static void main(String args[]) {
		Solutionn의배수고르기 s = new Solutionn의배수고르기();
		int[] numlist = {4,5,6,7,8,9,10,11,12};
		int[] res = s.solution(3, numlist);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solutionn의배수고르기 {
	public int[] solution(int n, int[] numlist) {
		int count = 0;
		for(int i=0; i<numlist.length; i++) {
			if(numlist[i] % n == 0) {
				count++;
			}
		}
		int[] answer = new int[count];
		
		count = 0;
		for(int i=0; i<numlist.length; i++) {
			if(numlist[i] % n == 0) {
				answer[count] = numlist[i];
				count++;
			}
		}
		return answer;
	}
}