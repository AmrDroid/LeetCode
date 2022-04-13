class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        
        spiralOutput(matrix, n, 0,1);
        
        return matrix;
    }

    private void spiralOutput(int[][] matrix,int n, int index,int count) {
        
        if (n == 0)
            return;
        
        if(index>n*n)return;
    
        System.out.println(count);
        
        int i, j;
        // (index, index) -> (index, n - index - 1)
        
        for (i = index, j = index; j < n - index; j++) {
            matrix[i][j]=count;
            count++;
        }
        
        for (i = index + 1, j = n - index - 1; i < n - index; i++) {
          
            matrix[i][j]=count;
            count++;
        
        }
        
        // (n - index - 1, n - index - 2) -> (n - index - 1, index)
        // avoid duplicate
        
        if (index != n - index - 1) {
            for (i = n - index - 1, j = n - index - 2; j >= index; j--) {
            matrix[i][j]=count;
            count++;
        
            }
        }
        
        // (n - index - 1, index) -> (index + 1, index)
        // avoid duplicate
        if (index != n - index - 1) {
            for (i = n - index - 2, j = index; i > index; i--) {
         matrix[i][j]=count;
            count++;
        
            }
        }
        spiralOutput(matrix, n,index+1,count);
    }
        
}