import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class ЦђБе_1546 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = Integer.MIN_VALUE;
		double hap = 0.0;
		
		for(int i=0; i<count; i++) {
			int jumsu = Integer.parseInt(st.nextToken());
			max = jumsu > max ? jumsu : max;
			hap += jumsu;
		}
		System.out.println((hap/max*100.0)/count);
		
		br.close();
	}
}
