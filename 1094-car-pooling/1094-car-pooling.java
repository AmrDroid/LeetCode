class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return true;
        
        int[] bucket = new int[1001];
        
        for (int[] trip : trips) {
            
            bucket[trip[1]] += trip[0];
            bucket[trip[2]] += -trip[0];

        }
        int cap = 0;
        for (int num : bucket) {
            cap += num;
            if (cap > capacity) return false;
        }
        return true;
    }
}