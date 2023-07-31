
public class 캐릭터의좌표 {
	public static void main(String args[]) {
		Solution캐릭터의좌표 s = new Solution캐릭터의좌표();
		String[] keyinput = {"left", "right", "up", "right", "right"};
		int[] board = {11, 11};
		int[] res = s.solution(keyinput, board);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution캐릭터의좌표 {
	public int[] solution(String[] keyinput, int[] board) {
		int[] answer = new int[2];
		int xEnd = board[0]/2;
		int yEnd = board[1]/2;
		int x = 0;
		int y = 0;
		for(int i=0; i<keyinput.length; i++) {
			if(keyinput[i].equals("left") && !(x==-xEnd)) {
				x -= 1;
			} else if(keyinput[i].equals("right") && !(x==xEnd)) {
				x += 1;
			} else if(keyinput[i].equals("up") && !(y==yEnd)) {
				y += 1;
			} else if(keyinput[i].equals("down") && !(y==-yEnd)) {
				y -= 1;
			}
		}
		answer[0] = x;
		answer[1] = y;
		return answer;
	}
}