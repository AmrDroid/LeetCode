class Solution {
    int r,c;
    
    private static final int[][] DIRS = {{-1, -1}, // top-left
 									 {-1, 0},  // top
									 {-1, 1},  // top-right
									 {0, -1},  // left
									 {0, 1},   // right
									 {1, -1},  // bottom-left
									 {1, 0},   // bottom
									 {1, 1}};  // bottom-right
    
    
    public void gameOfLife(int[][] board) {
        
        
        
         r=board.length;
         c=board[0].length;
        
        int res[][]=new int [r][c];
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int alive = aliveNeighbors(board, r, c, i, j);
			
                // Dead cell with 3 live neighbors becomes alive
		    	if (board[i][j] == 0 && alive == 3) // board[i][j] = 00
			    	board[i][j] = 2; // board[i][j] = 10
			
                // Live cell with 2 or 3 live neighbors lives on
			    else if (board[i][j] == 1 && (alive == 2 || alive == 3)) // board[i][j] = 01
			    	board[i][j] = 3; // board[i][j] = 11
                
            }
            
            
        }
        
        updateBoard(board,r,c);
    }
    
   
    
    
    private int aliveNeighbors(int[][] board, int rows, int cols, int i, int j) {
	    int alive = 0;
	    for (int dir[] : DIRS) {
		    var neighborX = i + dir[0];
		    var neighborY = j + dir[1];
		    if (isValid(neighborX, neighborY))
		    	alive += board[neighborX][neighborY] & 1;
    	    }
	      return alive;
    }
    
    
    
    boolean isValid(int i,int j)
    {
        if(i>=0&&i<r&&j>=0&&j<c)
            return true;
        return false;
    }
    
    private void updateBoard(int[][] board, int rows, int cols) {
	    for (var i = 0; i < rows; i++)
		    for (var j = 0; j < cols; j++)
			    board[i][j] >>= 1; // right shift 1 bit to replace old state with new state
    }
}