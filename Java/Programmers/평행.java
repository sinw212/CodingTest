
public class 평행 {
	public static void main(String args[]) {
		Solution평행 s = new Solution평행();
		int[][] dots = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};
		System.out.println(s.solution(dots));
	}
}

class Solution평행 {
	public int solution(int[][] dots) {
		int incliX1 = 0;
		int incliX2 = 0;
		int incliY1 = 0;
		int incliY2 = 0;
		
		incliX1 = dots[1][0]-dots[0][0];
		incliX2 = dots[3][0]-dots[2][0];
		incliY1 = dots[1][1]-dots[0][1];
		incliY2 = dots[3][1]-dots[2][1];
		if(incliY2 == (incliY1 * (incliX2/incliX1))) {
			return 1;
		}
		if(incliX1 == incliX2)  {
			if(incliY1 == incliY2) {
				return 1;
			}
		}			
		
		incliX1 = dots[2][0]-dots[0][0];
		incliX2 = dots[3][0]-dots[1][0];
		incliY1 = dots[2][1]-dots[0][1];
		incliY2 = dots[3][1]-dots[1][1];
		if(incliY2 == (incliY1 * (incliX2/incliX1))) {
			return 1;
		}
		if(incliX1 == incliX2)  {
			if(incliY1 == incliY2) {
				return 1;
			}
		}		
				
		incliX1 = dots[3][0]-dots[0][0];
		incliX2 = dots[2][0]-dots[1][0];
		incliY1 = dots[3][1]-dots[0][1];
		incliY2 = dots[2][1]-dots[1][1];
		if(incliY2 == (incliY1 * (incliX2/incliX1))) {
			return 1;
		}
		if(incliX1 == incliX2)  {
			if(incliY1 == incliY2) {
				return 1;
			}
		}				
		return 0;
	}
}