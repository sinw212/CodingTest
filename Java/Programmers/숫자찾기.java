
public class 숫자찾기 {
	public static void main(String args[]) {
		Solution숫자찾기 s = new Solution숫자찾기();
		System.out.println(s.solution(29183, 7));
	}
}

class Solution숫자찾기 {
	public int solution(int num, int k) {
//		int length = String.valueOf(num).length();
//		for(int i=0; i<length; i++) {
//			int pow = (int) Math.pow(10, length-1-i);
//			if(num/pow == k) {
//				return i+1;
//			}
//			num -= num/pow * pow;
//		}
//		return -1;
		
		String numStr = String.valueOf(num);
		String kStr = String.valueOf(k);
		
		int answer = numStr.indexOf(kStr);
		return answer < 0 ? -1 : answer+1;
	}
}