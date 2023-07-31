
public class 로그인성공 {
	public static void main(String args[]) {
		Solution로그인성공 s = new Solution로그인성공();
		String[] id_pw = {"meosseugi", "1234"};
		String[][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
		System.out.println(s.solution(id_pw, db));
	}
}

class Solution로그인성공 {
    public String solution(String[] id_pw, String[][] db) {
    	for(int i=0; i<db.length; i++) {
        	if(id_pw[0].equals(db[i][0])) {
        		if(id_pw[1].equals(db[i][1])) {
        			return "login";
        		} else {
        			return "wrong pw";
        		}
        	}
        }
        return "fail";
    }
}