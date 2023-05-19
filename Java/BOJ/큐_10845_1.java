import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ť_10845_1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		Queue que = new LinkedList();
		int last = 0;
		
		for(int i=0; i<count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String type = st.nextToken();
			
			if(type.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				que.add(num);
				last = num;
			} else if(type.equals("pop")) {
				System.out.println(que.isEmpty() ? "-1" : que.poll());
			}  else if(type.equals("size")) {
				System.out.println(que.size());
			} else if(type.equals("empty")) {
				System.out.println(que.isEmpty() ? "1" : "0");
			} else if(type.equals("front")) {
				System.out.println(que.isEmpty() ? "-1" : que.peek());
			} else if(type.equals("back")) {
				System.out.println(que.isEmpty() ? "-1" : last);
			}
		}
		br.close();
	}
}