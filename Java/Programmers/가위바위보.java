
public class 가위바위보 {
	public static void main(String args[]) {
		Solution가위바위보 s = new Solution가위바위보();
		System.out.println(s.solution("205"));
	}
}

class Solution가위바위보 {
	public String solution(String rsp) {
		String answer = "";
		for(int i=0; i<rsp.length(); i++) {
			if(rsp.charAt(i) == '2') {
				answer += "0";
			} else if(rsp.charAt(i) == '0') {
				answer += "5";
			} else {
				answer += 2;
			}
		}
		return answer;
	}
}
