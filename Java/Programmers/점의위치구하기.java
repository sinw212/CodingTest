
public class 점의위치구하기 {
	public static void main(String args[]) {
		Solution점의위치구하기 s = new Solution점의위치구하기();
		int[] dot = new int[] {2, 4};
		System.out.println(s.solution(dot));
	}
}

class Solution점의위치구하기 {
	public int solution(int[] dot) {
		if(dot[0] > 0) {
			if(dot[1] > 0) return 1;
			else return 4;
		} else {
			if(dot[1] > 0) return 2;
			else return 3;
		}
	}
}