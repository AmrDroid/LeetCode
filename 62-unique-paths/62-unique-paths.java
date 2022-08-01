class Solution {
    public int uniquePaths(int m, int n) {
//       int[][] dp = new int[m][n];
//         int i = 0;
//         for(; i < m; i++)
//             dp[i][0] = 1;
//         for(i = 0; i < n; i++)
//             dp[0][i] = 1;
//         for(i = 1; i < m; i++)
//             for(int j = 1; j < n; j++)
//                 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//         return dp[m-1][n-1];      
        
        
        
     int N = n + m - 2; // how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++) {
            res *= (double) (N - k + i) / (double) i;
        }

        return (int) Math.round(res);
    }
}
