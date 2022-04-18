class Solution {
    public void solveSudoku(char[][] board) {
          solve(board);
    }
    public boolean solve(char[][] board)
    {
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
        
                if(board[i][j]=='.')
                {
                
                    for(char k = '1'; k<='9'; k++)
                    {
                        board[i][j]=k;
                        if(isValid(board,i,j)&&solve(board))
                            return true;
                    }
                    board[i][j]='.';
                    return false;
                    
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int i,int j)
    {
        HashSet<Character> set = new HashSet<Character>();
        for(int m = 0; m < 9; m++)
        {
            if(board[m][j]=='.') continue;
            if(!set.add(board[m][j])) return false;
        }
        
        set = new HashSet<Character>();
        for(int m = 0; m < 9; m++)
        {
            if(board[i][m]=='.') continue;
            if(!set.add(board[i][m])) return false;
        }
        
        int m = i/3,n=j/3;
        
        set = new HashSet<Character>();
        
        for(int p=3*m;p<3*m+3;p++)
        {
            for(int q=3*n;q<3*n+3;q++)
            {
                if(board[p][q]=='.') continue;
                if(!set.add(board[p][q])) return false;
            }
        }
        
        return true;
    }
}