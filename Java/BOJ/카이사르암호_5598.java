import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 카이사르암호_5598 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cs = br.readLine();

		StringBuilder decode = new StringBuilder();

		for (int i = 0; i < cs.length(); i++) {
			switch (cs.charAt(i)) {
			case 'C':
				decode.append('Z');
				break;
			case 'B':
				decode.append('Y');
				break;
			case 'A':
				decode.append('X');
				break;
			default:
				decode.append((char)(cs.charAt(i) - 3));
			}
		}
		System.out.println(decode);
		
		br.close();
	}
}
