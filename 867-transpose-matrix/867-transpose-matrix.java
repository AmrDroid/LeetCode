class Solution {
    public int[][] transpose(int[][] matrix) {
        
        int res[][]=new int[matrix[0].length][matrix.length];
        int r=0,c=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                res[r][c]=matrix[i][j];
                r++;
            }
            c++;
            r=0;
        }
        
        return res;
    }
}