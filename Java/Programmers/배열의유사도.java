
public class 배열의유사도 {
	public static void main(String args[]) {
		Solution배열의유사도 s = new Solution배열의유사도();
		String[] s1 = new String[] {"a", "b", "c"};
		String[] s2 = new String[] {"com", "b", "d", "p", "c"};
		System.out.println(s.solution(s1, s2));
	}
}

class Solution배열의유사도 {
	public int solution(String[] s1, String[] s2) {
		int answer = 0;
		for(int i=0; i<s1.length; i++) {
			for(int j=0; j<s2.length; j++) {
				if(s1[i].equals(s2[j])) {
					answer++;
				}
			}
		}
		return answer;
	}
}
