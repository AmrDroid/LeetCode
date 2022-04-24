class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length,m= mat[0].length;
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                
                if(mat[i][j]==1 && !hasAdjacentZero(mat,i,j))
                    mat[i][j]=Integer.MAX_VALUE;                
            }
        }
        
        
       for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                
                if(mat[i][j]==1)
                    DFS(mat,n,m,i,j,-1);                
            }
       }
        return mat;
    }
    
    void DFS(int mat[][],int n,int m,int i,int j ,int val)
    {
        if(i<0||i>=n || j<0 || j>=m || mat[i][j]<=val)return;
        
        
        if(val>=0)
            mat[i][j]=val;
        
        DFS(mat,n,m,i+1,j,mat[i][j]+1);
        DFS(mat,n,m,i-1,j,mat[i][j]+1);
        DFS(mat,n,m,i,j+1,mat[i][j]+1);        
        DFS(mat,n,m,i,j-1,mat[i][j]+1);        
        
    }
    
    
    
     private boolean hasAdjacentZero(int[][] matrix, int r, int c) {

        if (r > 0 && matrix[r - 1][c] == 0) return true;
        if (r < matrix.length - 1 && matrix[r + 1][c] == 0) return true;
        if (c > 0 && matrix[r][c - 1] == 0) return true;
        if (c < matrix[0].length - 1 && matrix[r][c + 1] == 0) return true;

        return false;
    }
}