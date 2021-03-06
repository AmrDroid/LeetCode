class Solution {
    public int minimumLengthEncoding(String[] words) {
        
     Trie root=new Trie();
        root.next=new Trie[26];
        
        int length=0;
        for(String s:words){
            length += helper(s,root);
        }
        
        return length;
    }
    
    private int helper(String s,Trie node){
        boolean newBranch=false;
        int create=0;
        for(int i=s.length()-1;i>=0;i--){
            boolean newLevel = false;
            int id = s.charAt(i)- 'a';
            
            if(node.next==null){
                newLevel =true;
                node.next = new Trie[26];
            }
            
            if(node.next[id] == null){
                if(newLevel==false) newBranch=true;
                node.next[id]=new Trie();
                create++;
            }
            
            node=node.next[id];
        }
        
        return newBranch?s.length()+1 : create;
    }
    
    class Trie{
        Trie[] next=null;
    }
}