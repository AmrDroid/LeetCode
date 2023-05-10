class Solution {
    public int diagonalSum(int[][] mat) {
    
        int n = mat.length;
        
        int diagonalSum = 0;
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<mat[i].length;j++){
                if(i==j){
                    diagonalSum+=mat[i][j];
                }else if(i+j==n-1){
                    diagonalSum+=mat[i][j];
                }
            }
        }
        
        return diagonalSum;
    }
}