class Solution {
  
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n);
        
        int[] redundantConnection = null;
       
        for(int i = 0; i < n; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            if(!unionFind.union(a,b)){
                redundantConnection = edges[i];
                break;
            }
        }
        
        return redundantConnection;
    }
    




    
     class UnionFind {
        private int[] parents;
        private int[] sizes;
        
        private UnionFind(int n){
            parents = new int[n + 1];
            sizes = new int[n + 1];
            
            for(int i = 1; i <= n; i++){
                parents[i] = i;
                sizes[i] = 1;
            }
        }
        
        public boolean union(int p, int q){
            // find the parent of p and q
            int p1 = find(p);
            int p2 = find(q);
            
            // if both have the same parent, means they are already connected, return false
            if(p1 == p2){
                return false;
            } else {
                //otherwise, merge the smallest component with the largest
                if(sizes[p2] < sizes[p1]){
                    parents[p2] = p1;
                    sizes[p1] += sizes[p2];
                    sizes[p2] = 0;
                } else {
                    parents[p1] = p2;
                    sizes[p2] += sizes[p1];
                    sizes[p1] = 0;
                }
                
                return true;
            }
        }
            
        private int find(int p){
		    // stop when the element is parent of itself
            while(p != parents[p]){
                p = parents[p];
                
                // perform path compression
                parents[p] = parents[parents[p]];
            }
            
            return p;
        }
        
    }
}