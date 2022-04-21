class Solution {

    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    
        int[] visited = new int[n];
        
        // initialize all to max value
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        //set headID to it's informTime
        visited[headID] = informTime[headID];
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        // create graph
        
        for(int i=0; i<manager.length; i++) {
            
            ArrayList<Integer> curr = map.getOrDefault(manager[i], new ArrayList<>());
            
            curr.add(i);
            map.put(manager[i], curr);
        }
        
        Deque<Integer> q= new LinkedList<>();
       
        q.addLast(headID);
        
        // BFS
        while(q.size()!=0){
        
            int node = q.removeFirst();
            
            if(visited[node]!=Integer.MAX_VALUE && map.containsKey(node)){
            
                ArrayList<Integer> list = map.get(node);
                
                for(int i =0; i<list.size(); i++){
                
                    // dijkstra
                    if(visited[list.get(i)] > visited[node]+informTime[list.get(i)]){
                     
                        visited[list.get(i)] = visited[node]+informTime[list.get(i)];
                        q.addLast(list.get(i));
                    
                    }
                }
            }
        }
        
        int max = 0;
        for(int j =0; j<visited.length; j++){
            // if visited[j] == Integer.mAX_VALUE return -1;
            max = Math.max(max, visited[j]);
        }
        return max;
    }
}