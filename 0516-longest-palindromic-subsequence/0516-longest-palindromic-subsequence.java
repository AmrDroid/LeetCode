class Solution {
    public int longestPalindromeSubseq(String s) {
      int[][] dp = new int[s.length()][s.length()];
        
        for(int num=0;num<s.length();num++){
            for(int i=0;i<s.length();i++){
        
                int j = i+num;
                
                if(j>=s.length()){
                     break;
                 }
                 if(i==j){
                     dp[i][j] = 1;
                 } else {
                     
                     if(s.substring(i,i+1).equals(s.substring(j,j+1))){
                     
                         dp[i][j] =  2+dp[i+1][j-1];
                     
                     }
                     else {
                     
                         dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                     
                     }
                 }
            }
        }
        return dp[0][s.length()-1];
    }
}