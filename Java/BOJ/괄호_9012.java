import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class °ýÈ£_9012 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int yesno = 0;
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				if(s.substring(j, j+1).equals("(")) {
					yesno++;
				} else if(s.substring(j, j+1).equals(")")) {
					if(yesno==0) {
						yesno = Integer.MAX_VALUE;
						break;
					} else {
						yesno--;
					}
				}
			}
			if(yesno == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			yesno = 0;
		}
	}
}
