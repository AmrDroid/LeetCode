class Solution {
    
    // Priority Queue will hold all to locations in sorted order as requested
     HashMap<String, PriorityQueue> map = new HashMap<>();
    // Store output
    List<String> result = new ArrayList<>();

    private  void dfs(String airPort) {
        
        
        while (map.containsKey(airPort) && !map.get(airPort).isEmpty())
        {
        
            PriorityQueue<String> toAirports = map.get(airPort);
            String toAirport = toAirports.poll();
            dfs(toAirport);
        
        }
        result.add(0, airPort);
    }
    
    public  List<String> findItinerary(List<List<String>> tickets) {
    
        for (List<String> ticket: tickets) {
        
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue());
            }
            
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs("JFK");
        return result;
    }
}