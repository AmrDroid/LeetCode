class Solution {
    public int closedIsland(int[][] grid) {
         
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        // loop through all cells in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if we find an unvisited land cell, perform DFS to check if it's a closed island
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid, int i, int j, int m, int n) {
        // if the current cell is outside the grid boundary, it's not a closed island
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        // if the current cell is water or already visited, we don't need to search further
        if (grid[i][j] == 1) {
            return true;
        }
        // mark the current cell as visited by setting it to 1
        grid[i][j] = 1;
        // check all neighboring cells recursively
        boolean up = dfs(grid, i-1, j, m, n);
        boolean down = dfs(grid, i+1, j, m, n);
        boolean left = dfs(grid, i, j-1, m, n);
        boolean right = dfs(grid, i, j+1, m, n);
        // if any neighboring cell is not a closed island, then the current cell is also not a closed island
        return up && down && left && right;
    }
}