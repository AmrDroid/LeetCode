class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Pair>> graph = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph.get(from).add(new Pair(weight, to));
        }
        
        Set<Integer> visited = new HashSet<>();
        
        Queue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> (p1.weight - p2.weight));
       
        minHeap.offer(new Pair(0, k));
        
        int time = 0;
        
        while(!minHeap.isEmpty()) {
            
            Pair pair = minHeap.poll();
            int currWeight = pair.weight;
            int currVertex = pair.vertex;
            
            if(visited.contains(currVertex)) {
                continue;
            }
            
            visited.add(currVertex);
            
            time = Math.max(time, currWeight);
            
            List<Pair> neighbors = graph.get(currVertex);
           
            for(Pair neighbor : neighbors) {
            
                if(!visited.contains(neighbor.vertex)) {
                    neighbor.weight = currWeight + neighbor.weight;
                    minHeap.offer(neighbor);   
                }
            
            }
        
        }
        
        return visited.size() == n ? time : -1;
        
    }
}

class Pair {
    
    int weight;
    int vertex;
    
    public Pair(int weight, int vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}