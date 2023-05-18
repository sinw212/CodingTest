import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class È¦¼ö_2576 {
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hap = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<7; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num % 2 != 0) {
				hap += num;
				min = num < min ? num : min;
			}
		}
		if(hap == 0) {
			System.out.println(-1);
		} else {
			System.out.println(hap + "\n" + min);
		}
		
		br.close();
	}
}
