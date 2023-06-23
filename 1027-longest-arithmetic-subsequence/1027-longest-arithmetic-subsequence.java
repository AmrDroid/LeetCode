class Solution {
    public int longestArithSeqLength(int[] nums) {
    
        
        
        int max= 1 ;
        int n = nums.length;
        int dp [][]=new int [n][1001];
        
        for(int d[]:dp)
            Arrays.fill(d,1);
        
        for(int i=0;i<n;i++)
        {
            
            for(int j=0;j<i;j++)
            {
                
                int diff = nums[i]- nums[j];
                
                if(diff<0)
                {
                    diff = Math.abs(diff);                    
                }
                else
                    diff= diff+500;
                
                
                dp [i][diff]= Math.max(dp[i][diff],1+dp[j][diff]);
                
                max = Math.max(dp[i][diff],max);
                
                
            }
            
        }
        
        return max;
        
    
    }
}


