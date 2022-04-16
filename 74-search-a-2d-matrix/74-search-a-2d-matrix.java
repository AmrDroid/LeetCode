class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m= matrix[0].length;
        
        for(int i=0;i<n;i++)
        {
            
            
            if(target>=matrix[i][0]&&target<=matrix[i][m-1])
            {
                int l=0,h=m-1;
                while(l<=h)
                {
                    int mid=(l+h)/2;
              
                    if(matrix[i][mid]==target)
                        return true;                    
                    else if (matrix[i][mid]<target)
                        l++;
                    else
                        h--;
                }
                
            }
        
        }
        return false;
    }
}