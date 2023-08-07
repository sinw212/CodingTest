
public class x만큼간격이있는n개의숫자 {
	public static void main(String args[]) {
		Solutionx만큼간격이있는n개의숫자 s = new Solutionx만큼간격이있는n개의숫자();
		long[] res = s.solution(-4, 2);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solutionx만큼간격이있는n개의숫자 {
	public long[] solution(long x, int n) {
		long[] answer = new long[n];
		for(int i=0; i<n; i++) {
			answer[i] = x*(i+1);
		}
		return answer;
	}
}
