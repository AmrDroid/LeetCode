class Solution {
    public int longestIncreasingPath(int[][] matrix) {
    
        int n= matrix.length;
        int m=matrix[0].length;
        
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dp[i][j]=-1;
        
    
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = LIP(dp, matrix, n, m, i, j);

                }
            }

         int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dp[i][j]);
            }

        return max;    
        
    
    }
  int LIP(int dp[][], int mat[][], int n, int m, int x, int y) {
        // If value not calculated yet.
        if (dp[x][y] < 0) {
            int result = 0;

            if (x - 1 >= 0 && mat[x][y] < mat[x - 1][y])
                result = Math.max(result,1 + LIP(dp, mat, n, m, x - 1, y));

            if (x + 1 < n && mat[x][y] < mat[x + 1][y])
                result =Math.max(result, 1 + LIP(dp, mat, n, m, x + 1, y));

            if (y + 1 < m && mat[x][y] < mat[x][y + 1])
                result =  Math.max(result,1 + LIP(dp, mat, n, m, x, y + 1));

            if (y - 1 >= 0 && mat[x][y] < mat[x][y - 1])
                result =Math.max(result,1 + LIP(dp, mat, n, m, x, y - 1));

            dp[x][y] = Math.max(result, 1);
        }

        return dp[x][y];
    }
}