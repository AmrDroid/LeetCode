class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        int max=0;
		for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max=Math.max(max,nums[i]);
        }

        int[] dp = new int[max+1];
		dp[0] = 0;
    	dp[1] = map.getOrDefault(1,0);
        
		for(int i = 2; i <=max; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + i * map.getOrDefault(i,0));		
        }
        
		return dp[max];
    }
}