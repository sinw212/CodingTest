import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터큐_1966_1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				pq.add(arr[j]);
			}
			
			int answer = 0;
			int rtKey = Integer.MAX_VALUE;
			while(!pq.isEmpty()) {
				for(int k=0; k<arr.length; k++) {
					if(arr[k] == pq.peek()) {
						if(k == M) {
							answer++;
							rtKey = 0;
							break;
						} else {
							pq.poll();
							answer++;
						}
					}
				}
				if(rtKey == 0) {
					break;
				}
			}
			System.out.println(answer);
		}
	}
}
