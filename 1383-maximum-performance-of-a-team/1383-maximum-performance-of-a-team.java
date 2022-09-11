class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
     
        int MOD = 1000000007;
        int[][] eng = new int[n][2];
        for(int i =0;i<n;i++){
            eng[i][0] = speed[i];
            eng[i][1] = efficiency[i];
        }
        
        Arrays.sort(eng,(a,b)->b[1]-a[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long MaxPerformance = Long.MIN_VALUE;
        
        long sum =0;
        
        for(int i =0;i<n;i++){
            sum += eng[i][0];
            pq.add(eng[i][0]);
            if(pq.size() > k){
                sum -= pq.poll();
            }
            MaxPerformance = Math.max(MaxPerformance,sum*eng[i][1]);
        }
        return (int)(MaxPerformance%MOD);
        
        
        
    }
}