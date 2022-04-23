class Solution {
    public int minInsertions(String s) {
        
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        int n =s.length();
        
        int lcs = lcs(s,sb.toString(),n);
        
        return n - lcs;
        
    }
    
    int lcs(String s , String r , int n)
    {
        
        int dp[][]=new int [n+1][n+1];
        
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0)
                    dp[i][j]=0;
                else if( s.charAt(i-1)==r.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
}