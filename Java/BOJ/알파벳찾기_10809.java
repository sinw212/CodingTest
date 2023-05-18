import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ¾ËÆÄºªÃ£±â_10809 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr[] = new int[26];
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		
		String s = br.readLine();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(arr[c - 'a'] == -1) {
				arr[c - 'a'] = i;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			bw.write(arr[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
