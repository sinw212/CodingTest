import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
	public static void main(String args[]) {
		Solution문자열내마음대로정렬하기 s = new Solution문자열내마음대로정렬하기();
		String[] strings = {"abce", "abcd", "cdx"};
		String[] res = s.solution(strings, 1);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {
		String[][] arr = new String[strings.length][2];
		String[] answer = new String[strings.length];
		for(int i=0; i<strings.length; i++) {
			arr[i][0] = String.valueOf(i);
			arr[i][1] = String.valueOf(strings[i].charAt(n))+strings[i];
		}
		Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[1].toString().contentEquals(o2[1].toString()))
                    return o1[0].toString().compareTo(o2[0].toString());
                else
                    return o1[1].toString().compareTo(o2[1].toString());
            }			
        });
		
		for(int i=0; i<arr.length; i++) {
			int num = Integer.parseInt(arr[i][0]);
			answer[i] = strings[num];
		}
		return answer;
		
//		String[] answer = {};
//        ArrayList<String> arr = new ArrayList<>();
//        for (int i = 0; i < strings.length; i++) {
//            arr.add("" + strings[i].charAt(n) + strings[i]);
//            System.out.println("" + strings[i].charAt(n) + strings[i]);
//        }
//        Collections.sort(arr);
//        answer = new String[arr.size()];
//        for (int i = 0; i < arr.size(); i++) {
//            answer[i] = arr.get(i).substring(1, arr.get(i).length());
//        }
//        return answer;
		
//		Arrays.sort(strings, new Comparator<String>(){
//	          @Override
//	          public int compare(String s1, String s2){
//	              if(s1.charAt(n) > s2.charAt(n)) return 1;
//	              else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
//	              else if(s1.charAt(n) < s2.charAt(n)) return -1;
//	              else return 0;
//	          }
//	      });
//	      return strings;
	}
}