class Solution {
    public boolean isValidSudoku(char[][] board) {
      
        int row = board.length;
        int col= board[0].length;
        
        
        for(int i=0;i<row;i++)
        {
            Set<Character> s=new HashSet();
            for(int j=0;j<col;j++)
            {
            if(s.contains(board[i][j]))
                   return false;
            if(board[i][j]!='.')
                s.add(board[i][j]);
            } 
        }
        for(int i=0;i<row;i++)
        {
            Set<Character> s=new HashSet();
            for(int j=0;j<col;j++)
            {                
              if(s.contains(board[j][i]))
                   return false;
           
                if(board[j][i]!='.')
                    s.add(board[j][i]);
            }        
         
        }
         
        for(int i=0;i<row;i+=3)
        {
            for(int j=0;j<col;j+=3)
            {
                         System.out.println(i+" ,  "+j);

                    if(!checkGrid(board,i,j))
                        return false;
            }      
        
        System.out.println("---");
        }
        
        return true;
        
    }
    
    boolean checkGrid(char board[][],int i,int j)
    {
        
        Set<Character> s=new HashSet();
        
        for(int r=i;r<i+3;r++)
        {
            
            for(int c=j;c<j+3;c++)
            {
                  if(s.contains(board[r][c]))
                   return false;
            if(board[r][c]!='.')
                s.add(board[r][c]);
       
            }
        }
        
        return  true ;
    }
    
    
    
    
    
}