
public class 하샤드수 {
	public static void main(String args[]) {
		Solution하샤드수 s = new Solution하샤드수();
		System.out.println(s.solution(10));
	}
}

class Solution하샤드수 {
	public boolean solution(int x) {
		String strX = String.valueOf(x);
		int sum = 0;
		for(int i=0; i<strX.length(); i++) {
			sum += Integer.parseInt(String.valueOf(strX.charAt(i)));
		}
		return x % sum == 0 ? true : false;
	}
}