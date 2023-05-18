import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class �űԾ��̵���õ {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String new_id = br.readLine();
		
		Solution�űԾ��̵���õ s = new Solution�űԾ��̵���õ();
		System.out.println(s.solution(new_id));
	}
}

class Solution�űԾ��̵���õ {
	public String solution(String new_id) {
		String answer = "";
		
		answer = new_id.toLowerCase();

		answer = answer.replaceAll("[^-_.a-z0-9]", "");
		
		while(answer.contains("..")) {
			answer = answer.replace("..", ".");	
		}
		//answer = answer.replaceAll("[.]{2,}", "");
		
		if(answer.length() > 0) {
			if(answer.substring(0,1).equals(".")) {
				answer = answer.substring(1);
			}	
		}
		if(answer.length() > 0) {
			if(answer.substring(answer.length()-1).equals(".")) {
				answer = answer.substring(0, answer.length()-1);
			}	
		}
		//answer = answer.replaceAll("^[.]|[.]$", "")

		if(answer.isEmpty()) {
			answer += "a";
		}

		if(answer.length() >= 16) {
			answer = answer.substring(0, 15);
			
			if(answer.substring(answer.length()-1).equals(".")) {
				answer = answer.substring(0, answer.length()-1);
			}
			//answer = answer.replaceAll("^[.]|[.]$", "");
		}
		
		if(answer.length() <= 2) {
			while(answer.length() < 3) {
				answer += answer.substring(answer.length()-1);
			}
		}
		
		return answer;
	}
}
