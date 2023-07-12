class Solution {
   
    
      Map<Integer,Boolean> map;
    public List<Integer> eventualSafeNodes(int[][] graph) {

        map=new HashMap<>();

         List<Integer> res= new ArrayList<>();
        
        for(int i=0;i<graph.length;i++) {
         
            if(dfs(i,graph)) {
                 res.add(i);
             }
         
        }
        return res;
    }

    public boolean dfs(int i, int[][] graph) {
         if(map.containsKey(i)) {
             return map.get(i);
         }
         
        map.put(i,false);
        
        for(int a: graph[i]) {
              if(!dfs(a,graph)) {
                  return map.get(i);
              }
        }
        
        map.put(i,true);
        
        return map.get(i);
    }
}