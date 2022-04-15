class Solution {
    public int minDistance(String word1, String word2) {
        
        int n=word1.length();
        int m = word2.length();
        
        
        int dp[][]=new int [n+1][m+1];
        
        
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
               if(i==0)
                   dp[i][j]=j;
               else if(j==0)
                    dp[i][j]=i;
               else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
               else
                    dp[i][j]= 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                
            }
            
        }
        
        return dp[n][m];
    }

    
  
    //brute force
    int editDist(String str1, String str2, int m, int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same,
        // nothing much to do. Ignore last characters and
        // get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        return 1+ Math.min(editDist(str1, str2, m, n - 1), // Insert
                     Math.min(editDist(str1, str2, m - 1, n), // Remove
                      editDist(str1, str2, m - 1, n - 1)) // Replace
        );
    }
}