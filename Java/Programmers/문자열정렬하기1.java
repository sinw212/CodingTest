import java.util.Arrays;

public class 문자열정렬하기1 {
	public static void main(String args[]) {
		Solution문자열정렬하기1 s = new Solution문자열정렬하기1();
		int[] res = s.solution("hi12392");
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution문자열정렬하기1 {
	public int[] solution(String my_string) {
		my_string = my_string.replaceAll("[^0-9]", "");
		
		int answer[] = new int[my_string.length()];
		for(int i=0; i<my_string.length(); i++) {
//			answer[i] = Integer.parseInt(my_string.split("")[i]);
			answer[i] = my_string.charAt(i) - '0';
			
		}
		Arrays.sort(answer);
		return answer;
	}
}
