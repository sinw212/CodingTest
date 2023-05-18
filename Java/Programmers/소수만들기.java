
public class 소수만들기 {
	public static void main(String args[]) {
		int[] nums = new int[]{1,2,7,6,4};
		
		Solution소수만들기 s = new Solution소수만들기();
		System.out.println(s.solution(nums));
	}
}

class Solution소수만들기 {
	public int solution(int[] nums) {
		int answer = 0;
		int hap = 0;
		
		if(nums.length == 3) {
			hap = nums[0] + nums[1] + nums[2];
			if(sosu(hap)) {
				answer++;
			}
		} else {
			for(int i=0; i<nums.length-2; i++) {
				for(int j=i+1; j<nums.length-1; j++) {
					for(int k=j+1; k<nums.length; k++) {
						hap = nums[i] + nums[j] + nums[k];
						if(sosu(hap)) {
							answer++;
						}
					}
				}
			}
		}
		return answer;
	}
	
	public boolean sosu(int hap) {
		boolean isSosu = true;
		
		for(int i=2; i<hap; i++) {
			if(hap % i == 0) {
				isSosu = false;
				break;
			}
		}
		//for(int i=2; i<= (int)Math.sqrt(hap); i++) { ... }
		
		return isSosu;
	}
}