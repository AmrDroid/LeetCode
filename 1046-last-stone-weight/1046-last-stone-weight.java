class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq= new PriorityQueue( Collections.reverseOrder());
        int res=0;
        
        for(int i : stones)
            pq.add(i);
        
        while(pq.size()>1)
        {
            int f= pq.poll();
            int s= pq.poll();
            
            if(f!=s)
            {
                pq.add(Math.abs(f-s));    
            }           
        }
        
        
        return pq.isEmpty() ? 0 : pq.poll() ;
    }
}