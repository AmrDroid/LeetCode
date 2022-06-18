class WordFilter {
    class TrieNode{
        TrieNode children[];
        int index;
        TrieNode(){
            children = new TrieNode[26];
            index= -1;
        }
    }
    
    
    void add(String str, TrieNode root,int i){
        TrieNode curr = root;
        for(char c : str.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.index = i;
    }
    
    
    
    
    TrieNode prefixSearch(String str, TrieNode root){
        TrieNode curr = root;
        for(char c : str.toCharArray()){
            if(curr.children[c-'a'] == null) return null;
            curr = curr.children[c-'a'];
        }
        return curr;
    }
    
    
    
    
    void wordSearch(TrieNode node,ArrayList<Integer> list){
        if(node == null) return;
        if(node.index != -1) list.add(node.index);
        for(int i = 0; i < 26; i++){
            wordSearch(node.children[i],list);
        }
    }
    TrieNode root;
    TrieNode root1;
    public WordFilter(String[] words) {
        root = new TrieNode();
        root1 = new TrieNode();
        for(int i = 0; i < words.length; i++){
            add(words[i],root,i);
        }
        for(int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder(words[i]);     
            add(sb.reverse().toString(), root1,i);
        }
    }
    
    public int f(String prefix, String suffix) {
        ArrayList<Integer> list = new ArrayList<>();
        TrieNode node = prefixSearch(prefix,root);
        wordSearch(node,list);
        StringBuilder sb = new StringBuilder(suffix);
        node = prefixSearch(sb.reverse().toString(),root1);
        wordSearch(node,list);
        String res = "";
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for(int x : list){
            if(set.contains(x)){
                ans = Math.max(ans,x);
            }
            set.add(x);
        }
        return ans;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */