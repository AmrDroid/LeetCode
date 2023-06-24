class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int dp[][]=new int [21][5001*2];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return solve(0,n,rods,dp,0);
    }
    
    
    int solve(int i ,int n, int rods[],int dp[][],int diff)
    {
        if(i==n)
            return diff==0?0 : Integer.MIN_VALUE;
        
        if(dp[i][diff+5001]!=-1)
            return dp[i][diff+5001];
        
        
        int op1 = rods[i]+solve(i+1,n,rods,dp,rods[i]+diff);
        int op2 = solve(i+1,n,rods,dp,diff-rods[i]);
        int op3 = solve(i+1,n,rods,dp,diff);
         dp[i][diff+5001]= Math.max(op1,Math.max(op2,op3));
        return  dp[i][diff+5001];
        
    }
}