class Solution {
    public int longestStrChain(String[] words) {
   

        Arrays.sort(words,(a,b) ->a.length()-b.length());
      
        Map<String , Integer> m= new HashMap();
        
        
        
        int max=0;
        for(String w : words)
        {
            m.put(w,1);
    
            int len = w.length();
            
            for(int i=0;i<len;i++)
            {
                
                StringBuilder current = new StringBuilder(w);
                String next = current.deleteCharAt(i).toString(); //Time : Length
                //Check if the value for next is already calculated
                if(m.containsKey(next)) {
                    //Update the value in map with the maximum possible value
                    m.put(w, Math.max(m.get(w), m.get(next)+1));
                }
                
                
            }
                 max=Math.max(max,m.get(w));
               
            
        }
        
        return max;
        
        
  }
}