public class 다리를지나는트럭 {
	public static void main(String args[]) {
		int bride_length = 2;
		int weight = 10;
		int[] truck_weights = new int[] { 7, 4, 5, 6 };

		Solution다리를지나는트럭 s = new Solution다리를지나는트럭();
		System.out.println(s.solution(bride_length, weight, truck_weights));
	}
}

class Solution다리를지나는트럭 {
	int front = 0;
	int rear = -1;
	int[] queueArray;
	int sum = 0;
	int time = 0;

	public int solution(int bride_length, int weight, int[] truck_weights) {
		queueArray = new int[bride_length * truck_weights.length + 1];

		int i = 0;
		while(i < truck_weights.length) {
			if (empty()) { // 맨 처음 비어있을 때
				push(truck_weights[i]);
				i++;
				time++;
			} else if (full() == bride_length) { // 2대가 전부 찼을 때
				pop();
			} else { // 1대만 차있는 경우
				if(sum+truck_weights[i] <= weight) {
					push(truck_weights[i]);
					i++;
					time++;
				} else {
					push(0);
					time++;
				}
			}
		}
		return time+bride_length;
	}

	public boolean empty() {
		return rear + 1 == front;
	}

	public int full() {
		return rear - front + 1;
	}

	public void push(int n) {
		queueArray[++rear] = n;
		sum += n;
	}

	public void pop() {
		sum -= queueArray[front];
		queueArray[front++] = 0;
	}
}
