import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ÆÑÅä¸®¾ó_10872 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int result = 1;
		
		if(num != 0) {
			for(int i=1; i<=num; i++) {
				result *= i;
			}	
		}
		System.out.println(result);
		
		br.close();
	}
}
