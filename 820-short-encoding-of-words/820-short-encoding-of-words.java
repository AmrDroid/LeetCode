class Solution {
    public int minimumLengthEncoding(String[] words) {
        
  
        Trie trie = new Trie();
        
        for (String word : words) {
        
            StringBuffer sb = new StringBuffer(word);
            
            trie.add(sb.reverse().toString());
        
        }
        
        Map<Integer, Integer> map = trie.depthOfDepestWords();
        
        System.out.println(map);
        
        int numWords = 0;
        
        int totalLen = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        
            numWords += entry.getValue();
            
            totalLen += (entry.getKey()*entry.getValue());
        }
        
        totalLen += numWords;
        
        return totalLen;
    }
    
    class TrieNode {
        
        boolean isWordEnding = false;
        
        char val;
        
        boolean hasChildren = false;
        
        TrieNode[] children = new TrieNode[26];
        
        TrieNode(char c) {
            val = c;
        }
    }
    
    class Trie {
        
        TrieNode root = new TrieNode('*');
        
        Map<Integer, Integer> map;
        
        public void add(String s) {
        
            root.hasChildren = true;
            
            add(s, 0, root);
        }
        
        private void add(String s, int idx, TrieNode node) {
            
            
            if (idx >= s.length()) {
            
                node.isWordEnding = true;
                
                return;
            
            }
            
            char c = s.charAt(idx);
            
            if (node.children[c-'a'] == null) {
            
                node.hasChildren = true;
                TrieNode child = new TrieNode(c);
                node.children[c-'a'] = child;
            }
            add(s, idx+1, node.children[c-'a']);
        }
        
        
        private Map<Integer, Integer> depthOfDepestWords() {
        
            map = new HashMap<>();
            
            dfs(root, 0);
            
            return map;
        }
        
        private void dfs(TrieNode node, int depth) {
            
            if (!node.hasChildren) {
                map.put(depth, map.getOrDefault(depth, 0)+1);
                return;
            }
            
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    dfs(node.children[i], depth+1);
                }
            }
        }
    }
}