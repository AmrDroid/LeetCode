class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
     // Create a root node of TrieNode data structure
        TrieNode root = new TrieNode();

        // Add word to TrieNode datastructure
        for(String w: words) {
            root.addWord(w,root);
        }

        int rows = board.length, cols = board[0].length;
        
        Set<String> result = new HashSet<>();
        
        String word = "";
        
//        Set<Pair> visited = new HashSet<Pair>();
        
        boolean visited[][]=new boolean[board.length][board[0].length];
        
        for (int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                dfs(rows, cols, r, c, root, result, visited, word, board);
            }
        }

        return new ArrayList<String>(result);
    }

    private static void dfs(int rows, int cols, int r, int c, TrieNode current, Set<String> result, boolean [][] visited,    String word, char[][] board) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || 
            
            !current.containsKey(board[r][c])) {
            
            return;
        }
        
        visited[r][c]=true;
        
        word = word + board[r][c];
        
        current = current.children[board[r][c]-'a'];
        
        // Add to result if current word is endOf word
        if (current.isEndOfWord) {
            result.add(word);
        }
        
        dfs(rows, cols, r, c + 1, current, result, visited, word, board);
        
        dfs(rows, cols, r, c - 1, current, result, visited, word, board);
        
        dfs(rows, cols, r + 1, c, current, result, visited, word, board);
        
        dfs(rows, cols, r - 1, c, current, result, visited, word, board);
        
        visited[r][c]=false;
    }

}




    
    
     // trie node
     class TrieNode {
        TrieNode[] children = new TrieNode[26];
        // isEndOfWord is true if the node represents  // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    
     void addWord(String key,TrieNode root) {

        TrieNode pCrawl = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }
         
     boolean containsKey(char key) {        
         int index = key- 'a';         
         if(children[index]!=null) return true;         
         return false;         
    }
}