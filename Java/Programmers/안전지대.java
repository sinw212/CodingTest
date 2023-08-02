
public class 안전지대 {
	public static void main(String args[]) {
		Solution안전지대 s = new Solution안전지대();
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
		System.out.println(s.solution(board));
	}
}

class Solution안전지대 {
	public int solution(int[][] board) {
		int answer = 0;
		int[][] bomb = new int[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				bomb[i][j] = board[i][j];
			}
		} //깊은 복사

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 1) {
					checkBomb(i, j, bomb);
				}
			}
		}
		
		for(int i=0; i<bomb.length; i++) {
			for(int j=0; j<bomb[i].length; j++) {
				if(bomb[i][j] == 0) {
					answer++;
				}
			}
		}
		return answer;
	}
	
	void checkBomb(int i, int j, int[][] bomb) {
		int xCalc = 0;
		int yCalc = 0;
		int[] xAround = {0, -1, -1, 1, 0, 1, 1, -1};
		int[] yAround = {-1, -1, 0, -1, 1, 1, 0, 1};
		
		for(int k=0; k<xAround.length; k++) {
			xCalc = i + xAround[k];
			yCalc = j + yAround[k];
			
			if(xCalc >= 0 && yCalc >= 0) {
				if(xCalc < bomb.length && yCalc < bomb[0].length) {
					bomb[xCalc][yCalc] = 1;
				}
			}
		}
	}
}