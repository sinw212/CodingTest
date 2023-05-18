import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Ω∫≈√_10828 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		Stack stk = new Stack();
		
		for(int i=0; i<count; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String type = st.nextToken();
			
			if(type.equals("push")) {
				stk.push(Integer.parseInt(st.nextToken()));
			} else if(type.equals("pop")) {
				System.out.println(stk.isEmpty() ? "-1" : stk.pop());
			}  else if(type.equals("size")) {
				System.out.println(stk.size());
			} else if(type.equals("empty")) {
				System.out.println(stk.isEmpty() ? "1" : "0");
			} else if(type.equals("top")) {
				System.out.println(stk.isEmpty() ? "-1" : stk.peek());
			}
		}
		br.close();
	}
}
