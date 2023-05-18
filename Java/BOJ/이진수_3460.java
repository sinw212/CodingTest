import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ÀÌÁø¼ö_3460 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			int bny = Integer.parseInt(br.readLine());
			String str = Integer.toBinaryString(bny);
			
			for(int j=str.length()-1; j>=0; j--) {
				if(str.charAt(j) == '1') {
					System.out.print(str.length()-j-1 + " ");
				}
			}
		}
		br.close();
	}
}
