class Solution {
    
    int mod = (int)Math.pow(10,9)+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int n = locations.length;
        int dp[][]=new int [n][fuel+1];
        
        for(int d [] : dp )
            Arrays.fill(d,-1);
        return dfs(locations,start,finish,fuel,dp);
    }
    
    int dfs(int []locations,int cur,int goal,int fuel,int dp[][])
    {
        if(fuel<0)
            return 0;
        
        if(dp[cur][fuel]!=-1)return dp[cur][fuel];
        
        int result=0;
        if(cur==goal)result++;
        
        
        for(int i=0;i<locations.length;i++)
        {
            if(i==cur)continue;
            int next = Math.abs(locations[cur]-locations[i]);
            result+= dfs(locations,i,goal,fuel-next,dp);
            result%=mod;
        }
        dp[cur][fuel]=result;
        return result;
    }
}