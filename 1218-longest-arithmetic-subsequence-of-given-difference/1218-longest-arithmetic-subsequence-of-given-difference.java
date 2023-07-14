class Solution {
    public int longestSubsequence(int[] arr, int difference) {
               
        
        
        /**
        O(n) approach: since difference is fixed, the current value - 
        difference is the required number for the previous value in the sequence that we are trying to search. 
        So if that value exist in the left side of the scan then we can update the sequence length
        */
        
        HashMap<Integer,Integer> map = new HashMap<>();// index -> length of this sequence
        
        map.put(arr[0], 1);
        
        int res = 1;
        
        for(int i = 1 ;i < arr.length;i++){
            
            int prev = arr[i] - difference;

            // this line puts the beginning of the sequence into array if it has not existed yet. Otherwise, it updates the length of the sequence + 1.
            map.put(arr[i],map.getOrDefault(prev,0)+1);
            res = Math.max(res, map.get(arr[i]));
        }
        return res; 
    }
}