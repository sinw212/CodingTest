import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class º°Âï±â7_2444 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			for(int j=num-1; j>i; j--) {
				bw.write(" ");
			}
			for(int k=0; k<i*2+1; k++) {
				bw.write("*");
			}
			bw.newLine();
		}
		for(int i=0; i<num-1; i++) {
			for(int j=0; j<i+1; j++) {
				bw.write(" ");
			}
			for(int k=num*2-3; k>i*2; k--) {
				bw.write("*");
			}
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
