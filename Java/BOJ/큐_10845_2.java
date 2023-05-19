import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐_10845_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		ArrayQueue aq = new ArrayQueue(count);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String type = st.nextToken();
			
			if(type.equals("push")) {
				aq.push(Integer.parseInt(st.nextToken()));
			} else if(type.equals("pop")) {
				sb.append(aq.pop()).append("\n");
			}  else if(type.equals("size")) {
				sb.append(aq.size()).append("\n");
			} else if(type.equals("empty")) {
				sb.append(aq.empty()).append("\n");
			} else if(type.equals("front")) {
				sb.append(aq.front()).append("\n");
			} else if(type.equals("back")) {
				sb.append(aq.back()).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	static class ArrayQueue {
		private int front;
		private int rear;
		private int maxSize;
		private int[] queueArray;
		
		public ArrayQueue(int maxSize) {
			this.front = 0;
			this.rear = -1;
			this.maxSize = maxSize;
			this.queueArray = new int[maxSize];
		}
		
		public int size() {	
			return (rear - front + 1);
		}
		
		public int empty() {
			if(front == rear+1) {
				return 1;
			} else {
				return 0;
			}
		}
		
		//Queue rear에 데이터 추가
		public void push(int item) {
			queueArray[++rear] = item;
		}
		
		//Queue에서 front 데이터 조회 (peek)
		public int front() {
			if(empty() == 1) {
				return -1;
			} else {
				return queueArray[front];	
			}
		}
		
		public int back() {
			if(empty() == 1) {
				return -1;
			} else {
				return queueArray[rear];
			}
		}
		
		//Queue에서 front 데이터 출력
		public int pop() {
			if(empty() == 1) {
				return -1;
			} else {
				int item = front();
				front++;
				return item;	
			}
		}
	}
}