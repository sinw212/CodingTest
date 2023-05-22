import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 요세푸스문제_1158 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		CircleQueue cq = new CircleQueue(N, K);
		
		sb.append("<");
		while(!cq.empty()) {
			for(int i=1; i<K; i++) {
				cq.push();
			}
			sb.append(cq.pop());
			if(cq.size() != 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
		
		br.close();
	}
	
	static class CircleQueue {
		int rear;
		int front;
		int maxSize;
		int[] queueArray;
		
		public CircleQueue(int N, int K) {
			rear = -1;
			front = 0;
			this.maxSize = N*K;
			queueArray = new int[maxSize];
			for(int i=0; i<N; i++) {
				queueArray[++rear] = i+1;
			}
		}
		
		public int size() {
			return front - rear;
		}
		
		public boolean empty() {
			return rear+1 == front;
		}
		
		public void push() {
			queueArray[++rear] = queueArray[front++];
		}
		
		public int pop() {
			return queueArray[front++];
		}
	}
}
