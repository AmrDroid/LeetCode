class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        if (trips == null || trips.length == 0) return true;
        
        PriorityQueue<int[]> queue = buildQueue(trips);
        int cap = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            cap += point[1];
            while (!queue.isEmpty() && queue.peek()[0] == point[0]) {
                cap += queue.poll()[1];
            }
            if (cap > capacity) return false;
        }
        return true;
    }
    
    private PriorityQueue<int[]> buildQueue(int[][] trips) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(p -> p[0]));
        for (int[] trip : trips) {
            queue.offer(new int[]{trip[1], trip[0]});
            queue.offer(new int[]{trip[2], -trip[0]});
        }
        return queue;
    }
        
        
//  public boolean carPooling(int[][] trips, int capacity) {
        
//         if (trips == null || trips.length == 0) return true;
        
//         int[] bucket = new int[1001];
        
//         for (int[] trip : trips) {
            
//             bucket[trip[1]] += trip[0];
//             bucket[trip[2]] += -trip[0];

//         }
//         int cap = 0;
//         for (int num : bucket) {
//             cap += num;
//             if (cap > capacity) return false;
//         }
//         return true;
//     }
}