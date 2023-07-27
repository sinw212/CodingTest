
public class 중복된문자제거 {
	public static void main(String args[]) {
		Solution중복된문자제거 s = new Solution중복된문자제거();
		System.out.println(s.solution("We are the world"));
	}
}

class Solution중복된문자제거 {
	public String solution(String my_string) {
		String answer = "";
		for(int i=0; i<my_string.length(); i++) {
			if(!answer.contains(my_string.substring(i,i+1))) {
				answer += my_string.substring(i, i+1);
			}
		}
		return answer;
	}
}