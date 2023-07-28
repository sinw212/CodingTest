
public class 직사각형넓이구하기 {
	public static void main(String args[]) {
		Solution직사각형넓이구하기 s = new Solution직사각형넓이구하기();
		int[][] dots = {{1,1}, {2,1}, {2,2}, {2,1}};
		System.out.println(s.solution(dots));
	}
}

class Solution직사각형넓이구하기 {
	public int solution(int[][] dots) {
		int initX = dots[0][0];
		int initY = dots[0][1];
		int xSize = 0;
		int ySize = 0;
		
		for(int i=1; i<dots.length; i++) {
			if(dots[i][0] != initX) {
				xSize = Math.abs(initX-dots[i][0]);
			}
			if(dots[i][1] != initY) {
				ySize = Math.abs(initY-dots[i][1]);
			}
		}
		return xSize * ySize;
	}
}
