
public class 비밀지도 {
	public static void main(String args[]) {
		Solution비밀지도 s = new Solution비밀지도();
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		String[] res = s.solution(6, arr1, arr2);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ",");
		}
	}
}

class Solution비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
//		String[][] arr1Binary = new String[n][n];
//		String[][] arr2Binary = new String[n][n];
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				String intToBinary1 = Integer.toBinaryString(arr1[i]);
//				String intToBinary2 = Integer.toBinaryString(arr2[i]);
//				
//				if(intToBinary1.length() < n) {
//					String zeroAdd1 = "";
//					for(int k=0; k<n-intToBinary1.length(); k++) {
//						zeroAdd1 += "0";
//					}
//					intToBinary1 = zeroAdd1 + intToBinary1;
//				}
//				if(intToBinary2.length() < n) {
//					String zeroAdd2 = "";
//					for(int k=0; k<n-intToBinary2.length(); k++) {
//						zeroAdd2 += "0";
//					}
//					intToBinary2 = zeroAdd2 + intToBinary2;
//				}
//				arr1Binary[i][j] = String.valueOf(intToBinary1.charAt(j));
//				arr2Binary[i][j] = String.valueOf(intToBinary2.charAt(j));
//			}
//		}
//		
//		String[] answer = new String[n];
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(arr1Binary[i][j].equals("1") || arr2Binary[i][j].equals("1")) {
//					answer[i] += "1";
//				} else {
//					answer[i] += "0";
//				}
//			}
//		}
//		for(int i=0; i<n; i++) {
//			answer[i] = answer[i].replaceAll("null", "");
//			answer[i] = answer[i].replaceAll("1", "#");
//			answer[i] = answer[i].replaceAll("0", " ");
//		}
//		return answer;
		
		String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			answer[i] = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
			answer[i] = answer[i].substring(answer[i].length()-n);
//			answer[i] = String.format("%"+n+"s", Integer.toBinaryString(arr1[i] | arr2[i]));
			answer[i] = answer[i].replaceAll("1", "#");
			answer[i] = answer[i].replaceAll("0", " ");
		}
		return answer;
	}
}