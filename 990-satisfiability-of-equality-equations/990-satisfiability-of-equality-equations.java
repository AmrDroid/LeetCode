class Solution {
    public boolean equationsPossible(String[] equations) {
   
        //Union find all variables that must be equal to each other
        //Then we find the parent of those that cannot be equal to each other, if they are equal to each other then satisfiability fails.
        
        int[] parent = new int[26]; //Since they are lowercased letters
        
        for(int i = 0; i < 26; i++)
            parent[i] = i;
        
        for(String s: equations){
            
            if(s.contains("==")){
                int first = s.charAt(0)-'a';
                int second = s.charAt(3)-'a';
                union(parent, first, second);
            }
        }
        
        for(String s: equations){
            if(s.contains("!=")){
                int first = s.charAt(0)-'a';
                int second = s.charAt(3)-'a';
                if(find(parent, first) == find(parent, second)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void union(int[] parent, int childOne, int childTwo){
        int parentOne = find(parent, childOne);
        int parentTwo = find(parent, childTwo);
        parent[parentOne] = parentTwo;
    }
    
    public int find(int[] parent, int child){
        while(parent[child] != parent[parent[child]]){
            parent[child] = parent[parent[child]];
            child = parent[child];
        }
        return parent[child];
    }
}