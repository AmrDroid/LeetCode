class Solution {
         List<List<String>> res = new ArrayList<>();

    public int totalNQueens(int n) {
    
        
        char[][] board = new char[n][n];
        
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        
        helper(0, board);
        
        return res.size();
    }
    
    
    
    private void helper(int row, char[][] board) {
      
        int n = board.length;
        
        //base case, if found, then return        
        if (row == board.length) {
            res.add(toList(board));
            return;
        }
        
        
        //core
        for (int j = 0; j < n; j++) {
           
            if (!isValid(board, row, j)) {
                continue;
            }
            
            board[row][j] = 'Q';
            
            helper(row + 1, board);
            
            board[row][j] = '.';
        }
        
        
    }
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        
        //each col only contains one queen
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') 
                return false;
        }
        
        //left up no queen
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') 
                return false;
        }
        
        //right up no queen
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') 
                return false;
        }
        
        return true;
    }
    
    private List toList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}