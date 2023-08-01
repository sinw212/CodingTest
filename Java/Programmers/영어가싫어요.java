
public class 영어가싫어요 {
	public static void main(String args[]) {
		Solution영어가싫어요 s = new Solution영어가싫어요();
		System.out.println(s.solution("onefourzerosixseven"));
	}
}

class Solution영어가싫어요 {
	public long solution(String numbers) {
//		String answer = "";
//		while(numbers.length() != 0) {
//			switch(numbers.substring(0,1)) {
//				case "z": //zero
//					numbers = numbers.substring(4, numbers.length());
//					answer += 0;
//					break;
//				case "o": //one
//					numbers = numbers.substring(3, numbers.length());
//					answer += 1;
//					break;
//				case "t":
//					if(numbers.substring(1,2).equals("w")) { //two
//						numbers = numbers.substring(3, numbers.length());
//						answer += 2;
//						break;
//					} else { //three
//						numbers = numbers.substring(5, numbers.length());
//						answer += 3;
//						break;
//					}
//				case "f":
//					if(numbers.substring(1,2).equals("o")) { //four
//						answer += 4;
//					} else { //five
//						answer += 5;
//					}
//					numbers = numbers.substring(4, numbers.length());
//					break;
//				case "s":
//					if(numbers.substring(1,2).equals("i")) { //six
//						numbers = numbers.substring(3, numbers.length());
//						answer += 6;
//						break;
//					} else { //seven
//						numbers = numbers.substring(5, numbers.length());
//						answer += 7;
//						break;
//					}
//				case "e": //eight
//					numbers = numbers.substring(5, numbers.length());
//					answer += 8;
//					break;
//				case "n": //nine
//					numbers = numbers.substring(4, numbers.length());
//					answer += 9;
//					break;
//			}	
//		}
//		return Long.parseLong(answer);
		
//		return Long.parseLong(
//				numbers.replaceAll("zero", "0")
//						.replaceAll("one", "1")
//						.replaceAll("two", "2")
//						.replaceAll("three", "3")
//						.replaceAll("four", "4")
//						.replaceAll("five", "5")
//						.replaceAll("six", "6")
//						.replaceAll("seven", "7")
//						.replaceAll("eight", "8")
//						.replaceAll("nine", "9")
//				);
		
		String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		for(int i=0; i<arr.length; i++) {
			numbers = numbers.replaceAll(arr[i], String.valueOf(i));
		}
		return Long.parseLong(numbers);
	}
}