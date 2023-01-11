class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // constructing graph from edges for better time complexity while searching child nodes
        List<Integer>[] graph = new ArrayList[n];
        // Initialising array with arraylist
        for(int i=0;i<n;i++)
        graph[i] = new ArrayList();
        // setting edges in graph 
        // adding edges for both nodes because it is a unDirectional Graph
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        return dfs(graph,0,-1,hasApple);
    }

    int dfs(List<Integer>[] graph, int curr,int parent, List<Boolean> hasApple){
        
        int time = 0;

        // searching in child nodes for any apple 
        for(int child : graph[curr]){
            if(child == parent){  // no need to visit the parent again
                continue;
            }
           int time_from_my_child = dfs(graph, child, curr, hasApple);
        
        // Adding 2 if current node has apple or child node has apple else no need to visit there return 0
        if(time_from_my_child > 0 || hasApple.get(child) == true){
            time += time_from_my_child + 2;
        }
     }
        return time;
    }
}