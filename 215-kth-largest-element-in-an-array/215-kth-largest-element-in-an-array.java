class Solution {
    public int findKthLargest(int[] nums, int k) {
        
     // insert all the elements of vector in priority queue
        PriorityQueue<Integer> pq= new PriorityQueue(Collections.reverseOrder());
       
        for(int i: nums)pq.add(i);
        int x = k-1;
		// loop through k-1 till 0 and pop the elements
        
        while(x-->0) 
            pq.poll();
		// return the top element from queue
        
        return pq.peek();
    
    
    }
}