class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
 
        Deque<long[]> dq = new LinkedList<>();
        long sum = 0;
        long ans = Long.MAX_VALUE;
        
        for(int i = 0; i < nums.length;i++){
            sum += 1L * nums[i];
        
            if(sum >= k) ans = Math.min(ans,i + 1);
            
            long curr[] = null;
            
            for(;!dq.isEmpty() && (sum - dq.peekLast()[0]) >= k;){
                curr = dq.pollLast();
            }
            
            if(curr != null) ans = Math.min(ans,i - curr[1]);
            
            for(;!dq.isEmpty() && sum <= dq.peekFirst()[0];){
                dq.pollFirst();
            }
            dq.addFirst(new long[]{sum,i});
        }
        return ans == Long.MAX_VALUE ? -1 : (int)ans; 
}
}