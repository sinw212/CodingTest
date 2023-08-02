import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 겹치는선분의길이 {
	public static void main(String args[]) {
		Solution겹치는선분의길이 s = new Solution겹치는선분의길이();
		int[][] lines = {{0, 10}, {1, 3}, {4, 7}};
		System.out.println(s.solution(lines));
	}
}

class Solution겹치는선분의길이 {
	public int solution(int[][] lines) {
//		Arrays.sort(lines, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		
//		int[] count = new int[201];
//		for(int i=0; i<3; i++) {
//			for(int j=lines[i][0]+100; j<lines[i][1]+100; j++) {
//				count[j] += 1;
//			}
//		}
//		int answer = 0;
//		for(int i=0; i<count.length; i++) {
//			if(count[i] > 1) {
//				answer++;
//			}
//		}
//		return answer;
		
		Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<lines.length; i++) {
            for (int j=lines[i][0]; j<lines[i][1]; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                answer++;
            }
        }
        return answer;
	}
}
