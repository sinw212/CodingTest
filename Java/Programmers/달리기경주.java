import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class 달리기경주 {
	public static void main(String args[]) {
		Solution달리기경주 s = new Solution달리기경주();
		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };
		String[] res = s.solution(players, callings);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
}

class Solution달리기경주 {
	public String[] solution(String[] players, String[] callings) {
//		List<String> awards = Arrays.asList(players);
//		for(int i=0; i<callings.length; i++) {
//			int index = awards.indexOf(callings[i]);
//			Collections.swap(awards, index, index-1);
//		}
//		return awards.toArray(new String[awards.size()]);

//		for (int i = 0; i < callings.length; i++) {
//			for (int j = 0; j < players.length; j++) {
//				if (callings[i] == players[j]) {
//					String currentRank = players[j];
//					String winRank = players[j - 1];
//					players[j - 1] = currentRank;
//					players[j] = winRank;
//				}
//			}
//		}
//		return players;

		Map<String, Integer> mapRank = new HashMap<>();
		Map<Integer, String> mapPlayer = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			mapRank.put(players[i], i);
			mapPlayer.put(i, players[i]);
		}

		for (int i = 0; i < callings.length; i++) {
			int currentRank = mapRank.get(callings[i]);
			String winPlayer = mapPlayer.get(currentRank - 1);

			mapPlayer.put(currentRank - 1, callings[i]);
			mapPlayer.put(currentRank, winPlayer);

			mapRank.put(callings[i], currentRank - 1);
			mapRank.put(winPlayer, currentRank);
		}

		String[] answer = new String[players.length];
		for (Entry<Integer, String> entry : mapPlayer.entrySet()) {
			answer[entry.getKey()] = entry.getValue();
		}
		
		return answer;

//		HashMap<String, Integer> indexMap = new HashMap<>();
//
//        for (int i = 0; i < players.length; i++) {
//            indexMap.put(players[i], i);
//        }
//
//        for (String calling : callings) {
//            int idx = indexMap.get(calling);
//            if (idx > 0) {
//                String temp = players[idx - 1];
//                players[idx - 1] = players[idx];
//                players[idx] = temp;
//
//                indexMap.put(players[idx - 1], idx - 1);
//                indexMap.put(players[idx], idx);
//            }
//        }
//		
//        return players;
	}
}