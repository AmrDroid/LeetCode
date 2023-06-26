class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
     
      PriorityQueue<Integer> p1=new PriorityQueue();
      PriorityQueue<Integer> p2=new PriorityQueue();
        
     int c=0,i=0,j=costs.length-1;
        
        long ans=0;
        while(c<k)
        {
            
            while(p1.size()<candidates&&i<=j)
            {
                p1.offer(costs[i++]);
            }
            
            while(p2.size()<candidates&&i<=j)
            {
                p2.offer(costs[j--]);
            }
            
            
            int first = p1.size()>0 ?   p1.peek() : Integer.MAX_VALUE;
            
            int second = p2.size()>0 ?   p2.peek() : Integer.MAX_VALUE;
            
            if(first<=second)
                ans+=p1.remove();
            else
                ans+=p2.remove();
            
            c++;
            
            
        }
        
        
        return ans;
    }
}






   