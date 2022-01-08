class Solution {
    public int cherryPickup(int[][] grid) {
        
             int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        
        return solve(grid, dp, 0, 0, grid[0].length-1);
    }
    
    int[][] dir = new int[][]{{1,0}, {1,-1}, {1,1}}; 
    
    public int solve(int[][] grid, int[][][] dp, int row, int r1, int r2) {
        
        if (!check(row, r1, grid.length, grid[0].length) || 
            !check(row, r2, grid.length, grid[0].length)) 
            return Integer.MIN_VALUE;
        
        if (dp[row][r1][r2] != 0)
            return dp[row][r1][r2];
        
        int max = 0; 
        int sum = 0; 
        
        if (r1 == r2) { 
            sum = grid[row][r1];
        } else {
            sum = grid[row][r1] + grid[row][r2];
        }
        
        if (row == grid.length-1) // if we reach the last row we will return the score of that row
            return sum;
        
        for (int i = 0 ; i < 3; i++) {
        
            for (int j = 0 ; j < 3; j++) {
            
                int nextRow = row + dir[i][0];
                
                int nextR1 = r1 + dir[i][1];
                
                int nextR2 = r2 + dir[j][1];
                
                max = Math.max(max, solve(grid, dp, nextRow, nextR1, nextR2)); // find the maximum score we can get from this state
            }
        }
        
        if (max > 0) {
            dp[row][r1][r2] = sum + max;
            return sum + max;
        } 
        return Integer.MIN_VALUE;
    }
    
    public boolean check(int i, int j, int R, int C) {
        if (i < 0 || i >= R || j < 0 || j >= C)
            return false;
        return true;
    }
}