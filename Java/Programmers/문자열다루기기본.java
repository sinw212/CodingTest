
public class 문자열다루기기본 {
	public static void main(String args[]) {
		Solution문자열다루기기본 s = new Solution문자열다루기기본();
		System.out.println(s.solution("0x16"));
	}
}

class Solution문자열다루기기본 {
	public boolean solution(String s) {
//		if(s.length() == 4 || s.length() == 6) {
//			try {
//				long num = Integer.parseInt(s);
//				return true;
//			} catch (Exception e) {
//			}	
//		}
//		return false;
		
		return s.matches("[0-9]{4}|[0-9]{6}");
	}
}