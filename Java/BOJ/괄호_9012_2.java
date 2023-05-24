import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class °ýÈ£_9012_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Stack stk = new Stack();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (c == '(') {
					stk.push(c);
				} else { // c == ')'
					if (stk.empty()) {
						stk.push(c);
						break;
					} else {
						stk.pop();
					}
				}
			}
			System.out.println(stk.empty() ? "YES" : "NO");
		}
		
		br.close();
	}

	static class Stack {
		int stackArray[] = new int[50];
		int top = -1;

		public boolean empty() {
			return top == -1;
		}

		public void push(char c) {
			stackArray[++top] = c;
		}

		public void pop() {
			top--;
		}
	}
}
