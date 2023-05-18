import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 최소최대_10818 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<count; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = num > max ? num : max;
			min = num < min ? num : min;
		}
		
		System.out.println(min + " " + max);
		
		br.close();
	}
}
