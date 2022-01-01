class Solution {
    public int maxCoins(int[] nums) {
        
     // Empty array
        if(nums==null || nums.length == 0)return 0;
        
        int n = nums.length;
        
        // dp[i][j]: Max coins obtained by bursting all balloons between i and j inclusive
        int[][] dp = new int[n][n];
        
        // Left and right limits of subarray
        int l,r;

        // lCoins,rCoins: Coins due to left and right of current balloon being treated as last balloon
        // curr:          Coins due to last balloon being burst
        int lCoins,rCoins,curr;
        // Gap between left and right denoted by i
        for(int i=0;i<n;i++){
            
            for(l=0;l+i<n;l++){
                // right limit
            
                r=l+i;
                
                // Every balloon in the l,r subarray is treated as last balloon to be burst one-by-one and the max value is chosen
                
                for(int k=l;k<=r;k++){

                    // Coins due to balloons on left of k being burst
                    lCoins = (k>l)?dp[l][k-1]:0;
                    
                    // Coins due to balloons on right of k being burst
                    rCoins = (k<r)?dp[k+1][r]:0;
                    
                    // The balloons for left and right of k are present outside the l,r subarray
                    curr = nums[k] * ((l>0)?nums[l-1]:1) * ((r<n-1)?nums[r+1]:1);

                    dp[l][r] = Math.max(dp[l][r],curr + lCoins + rCoins);
                }
            }
        }

        // DP value for the entire subarray
        return dp[0][n-1];
    }
}