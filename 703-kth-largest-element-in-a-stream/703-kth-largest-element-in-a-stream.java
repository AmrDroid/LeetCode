class KthLargest {

    PriorityQueue<Integer> minHeap;
    
    int k;
    
    public KthLargest(int k, int[] nums) {
    
        minHeap = new PriorityQueue<>(k);
        
        this.k = k;
        
        for(int x: nums){
            add(x);
        }
    }
    
    public int add(int val) {
        
        minHeap.add(val);
        
        if(minHeap.size()>k)
            minHeap.remove();
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */