class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int res[][]=new int [m][n];
        List<List<Integer>> list=new ArrayList();
        
        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                
                int newVal = ((r*n+c)+k)%(m*n);
                
                int newR= newVal/n;
                int newC= newVal%n;
                
                res[newR][newC]=grid[r][c];
                
            }
        }
        
        
        
        for(int r=0;r<m;r++)
        {
            List<Integer> ro=new ArrayList();
            for(int c=0;c<n;c++)
            {
               ro.add(res[r][c]);
            }
             list.add(r,ro);
        }
        
         
    return list;    
    }
    
}