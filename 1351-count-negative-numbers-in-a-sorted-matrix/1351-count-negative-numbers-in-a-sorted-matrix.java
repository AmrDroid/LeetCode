class Solution {
    public int countNegatives(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int res=0;
        for(int i=0;i<row;i++)
        {
            for(int j=col-1;j>=0;j--)
            {
                if(grid[i][j]<0)
                    res++;
                else if(grid[i][j]>=0)
                    break;                
            }
        }
        
    return res;
    }
}