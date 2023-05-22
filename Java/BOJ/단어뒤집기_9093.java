import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 단어뒤집기_9093 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			while(st.hasMoreTokens()) {
				StringBuilder sb = new StringBuilder(st.nextToken());
				result.append(sb.reverse()).append(" ");
			}
			result.append("\n");
		}
		System.out.println(result);
		br.close();
	}
}
