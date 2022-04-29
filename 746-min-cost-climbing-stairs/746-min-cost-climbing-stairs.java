class Solution {
    public int minCostClimbingStairs(int[] cost) {
     
    
        int a = cost[0] , b = cost[1];
       
        for(int n = 2; n < cost.length ; n++){
           
            int min = Math.min(a , b);
        
            int sum = min + (n == cost.length ? 0 : cost[n]);
            
            a = b;
            b = sum;
            
        }
        return Math.min(a,b);
    }
}