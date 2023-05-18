import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ÃÖ´ñ°ª_2562 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int max = Integer.parseInt(br.readLine());
		int count = 1;
		int index = count;
		
		for(int i=0; i<8; i++) {
			int num = Integer.parseInt(br.readLine());
			count++;
			if(num > max) {
				max = num;
				index = count;
			}
		}
		
		System.out.println(max);
		System.out.println(index);
		
		br.close();
	}
}
