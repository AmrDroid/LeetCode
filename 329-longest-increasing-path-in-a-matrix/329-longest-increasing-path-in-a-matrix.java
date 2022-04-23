class Solution {
    int maxLen= 0;//Stores the Maximum Increasing path length in the matrix 
    int[][] dp;
    
    public int longestIncreasingPath(int[][] matrix) {
        
        dp= new int[matrix.length][matrix[0].length];//Each cell in dp store's the maximum increasing path from that node 
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ( dp[i][j] == 0){//Only exploring the non explored node 
                    maxLen= Math.max(maxLen, dfs(i, j, -1, matrix));    
                }
            }
        }
        return maxLen;
    }
    
    private int dfs(int i, int j, int prev, int[][] matrix) {//prev to store the previous value visited 
        
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) //Base Case 
            return 0;
        
        
        if (dp[i][j] > 0) //If incresing path exists from this coordinate, we are returning it from dp table 
            return dp[i][j];
        
        int res= 0;//stores the maximum incresing path length for this co-ordinate 
        
        //+1 because to include the current node 
        res= Math.max(res, 1 + dfs(i + 1, j, matrix[i][j], matrix));//down 
        res= Math.max(res, 1 + dfs(i - 1, j, matrix[i][j], matrix));//up
        res= Math.max(res, 1 + dfs(i, j + 1, matrix[i][j], matrix));//left
        res= Math.max(res, 1 + dfs(i, j - 1, matrix[i][j], matrix));//right
        
        dp[i][j]= res;//memorising the increasing path length
        
        return res;//returning to parent to decide their maximum path length
    }
}