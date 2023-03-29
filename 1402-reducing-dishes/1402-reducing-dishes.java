class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        
        int dp[][]=new int[n][n+1];
        for(int []arr : dp)
            Arrays.fill(arr,-1);
        
        Arrays.sort(satisfaction);
        
        return recur(dp,satisfaction,0,1);
    }
    
    int recur(int dp[][],int sat[],int i ,int t ){
        
        if(i>=sat.length)
            return 0;
        
        
        if(dp[i][t]!=-1)
            return dp[i][t];
        
        
        dp[i][t]=Math.max(
            
            sat[i]*t+recur(dp,sat,i+1,t+1),
            
            recur(dp,sat,i+1,t)
        
        );
        
        return dp[i][t];        
    }
    
}