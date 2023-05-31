import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {
	public static void main(String args[]) {
		int[] priorities = new int[] {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		Solution프로세스 s = new Solution프로세스();
		System.out.println(s.solution(priorities, location));
	}
}

class Solution프로세스 {
	public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }   
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}
