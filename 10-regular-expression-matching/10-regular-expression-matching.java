class Solution {
    public boolean isMatch(String s, String p) {
        
      int n=s.length();
        int m=p.length();
       
        
        return dfs(0,0,n,m,s,p);
    }
    
    
    boolean dfs(int i,int j,int n,int m ,String s ,String p)
    {
        
        if(i>=n&&j>=m)return true;
        
        
        if(j>=m)return false;
        
        
        boolean match =  (i<n) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        
        if(j+1<m&& p.charAt(j+1)=='*')
            return (match && dfs(i+1,j,n,m,s,p))  
                    || dfs(i,j+2,n,m,s,p);
        
        
        if(match)
            return dfs(i+1,j+1,n,m,s,p);
        
        
        return false;        
    }
}