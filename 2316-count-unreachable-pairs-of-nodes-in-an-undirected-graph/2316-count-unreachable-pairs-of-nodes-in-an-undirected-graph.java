class Solution {
    public long countPairs(int n, int[][] edges) {
        
        
        
        
        boolean visited[]=new boolean[n];
        Arrays.fill(visited,false);
        
        List<List<Integer>> adj=new ArrayList();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList());
        
        
        for(int edge[] : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        
        long pairs=0;
        
        
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
               long currentComponentSize= dfs(i,adj,visited,new long[1]);
               long remainingNodes= n- currentComponentSize;
               pairs += currentComponentSize * remainingNodes;
                
            }
        }
            
        return pairs/2;
    }
    
    
    long dfs(int curNode , List<List<Integer>> adj, boolean[] visited, long count[])
    {
        
        if(visited[curNode])
            return count[0];
        
        visited[curNode]=true;
        count[0]++; 
        for(int node : adj.get(curNode) )
        {
            dfs(node,adj,visited,count);
        }
        
        
        return count[0];
    }
        
        
        
}