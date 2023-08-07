
public class 핸드폰번호가리기 {
	public static void main(String args[]) {
		Solution핸드폰번호가리기 s = new Solution핸드폰번호가리기();
		System.out.println(s.solution("01033334444"));
	}
}

class Solution핸드폰번호가리기 {
	public String solution(String phone_number) {
//		return String.format("%"+phone_number.length()+"s", phone_number.substring(phone_number.length()-4)).replaceAll(" ", "*");
		
//		return phone_number.substring(0, phone_number.length()-4).replaceAll(".", "*") + phone_number.substring(phone_number.length()-4);
		
		String answer = "";
		for(int i=0; i<phone_number.length()-4; i++) {
			answer += "*";
		}
		return answer += phone_number.substring(phone_number.length()-4);
	}
}
