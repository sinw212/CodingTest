import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ¾à¼ö_1037 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<count; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = num > max ? num : max;
			min = num < min ? num : min;
		}
		System.out.println(max * min);
		
		br.close();
	}
}
