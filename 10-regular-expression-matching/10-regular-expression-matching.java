class Solution {
    public boolean isMatch(String s, String p) {
        
      int n=s.length();
        int m=p.length();
       
        boolean dp[][]=new boolean[n+1][m+1];
        
        
        return dfs(0,0,n,m,s,p,dp);
    }
    
    
    boolean dfs(int i,int j,int n,int m ,String s ,String p,boolean dp[][])
    {
        
        if(i>=n&&j>=m)return true;
        
        
        if(j>=m)return false;
        
        if(i<n&&j<m&&dp[i][j])return true;
        
        
        boolean match =  (i<n) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        
        if(j+1<m&& p.charAt(j+1)=='*')
        {
            dp[i][j] = (match && dfs(i+1,j,n,m,s,p,dp))  
                    || dfs(i,j+2,n,m,s,p,dp);
            
            return dp[i][j];
        
        }
        
        if(match){
            dp[i][j]= dfs(i+1,j+1,n,m,s,p,dp);        
            return dp[i][j];
        }
        dp[i][j]=false;
        return false;        
    }
}