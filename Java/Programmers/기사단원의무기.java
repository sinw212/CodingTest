
public class 기사단원의무기 {
	public static void main(String args[]) {
		Solution기사단원의무기 s = new Solution기사단원의무기();
		System.out.println(s.solution(10, 3, 2));
	}
}

class Solution기사단원의무기 {
	public int solution(int number, int limit, int power) {
		int[] ys = new int[number];

		for (int i = 0; i < number; i++) {
			int count = 0;
			for (int j = 1; j * j <= i+1; j++) {
				if (j * j == (i+1)) count++;
				else if ((i+1) % j == 0) count += 2;	
			}
			ys[i] = count;
		}

		int answer = 0;
		for (int i = 0; i < number; i++) {
			if (ys[i] > limit) {
				ys[i] = power;
			}
			answer += ys[i];
		}
		
		return answer;
	}
}