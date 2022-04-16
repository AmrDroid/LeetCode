class Solution {
    public int climbStairs(int n) {
        
       return staircaseTraversal(n,2);
    }
    
     public int staircaseTraversal(int height, int maxSteps) {
    
         // Write your code here.
        int[] numberOfWays = new int[height + 1];
        
         numberOfWays[0] = 1;

        int currentWays = 0, start = 0, end = 0;

        for (int currHeight = 1; currHeight <= height; currHeight++) {
            start = currHeight - maxSteps - 1;
            end = currHeight - 1;

            if (start >= 0) currentWays -= numberOfWays[start];

            currentWays += numberOfWays[end];
            numberOfWays[currHeight] = currentWays;
        }

        return numberOfWays[height];
    }   
   
}