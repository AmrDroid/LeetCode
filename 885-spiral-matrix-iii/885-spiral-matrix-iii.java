class Solution {
    public int[][] spiralMatrixIII(int r, int c, int r0, int c0) {
        
        int mat[][]=new int[r*c][2];
        
        int i=0;
        
        int dir[] =new int []{0, 1, 0,-1, 0};
        
        int len=0;
        
        int d=0;
        
        mat[i++]=new int[]{r0,c0};
        
        while(i<r*c)
        {
            if(d==0||d==2)
                len++;
            
            for(int k=0;k<len;k++)
            {
                r0+=dir[d];
                
                c0+=dir[d+1];
                
                if(r0>=0&&r0<r&&c0>=0&&c0<c)
                    mat[i++]=new int[]{r0,c0};
                
            }
            d = (d + 1) % 4;   
        }
        
        
        return mat;    
    }
    

}