class Solution {
    public int minSumOfLengths(int[] arr, int target) {
           
       int n = arr.length;
       
       //best is used to store the length of shortest sub-array with total sum of target up to i inclusively
       int best[] = new int[n];
       
       //initialize the best array
       Arrays.fill(best, Integer.MAX_VALUE);
       
       //for prefix sum
       int sum = 0;
       
       //the starting index of the sliding window
       int start = 0;
       
       //ans is to stored the result
       int ans = Integer.MAX_VALUE;
       
       //bestSoFar is the length of shortest sub-array with total sum of target across arr
       int bestSoFar = Integer.MAX_VALUE;
       
       //i is the ending index of the sliding window
       for(int i = 0; i < n; i++){
           //calculate the prefix sum up to i
           sum += arr[i];
           
           //move the start to the left while sum > target
           while(sum > target){
               sum -= arr[start];
               start++;
           }
           
           if(sum == target){
               
               //the current sliding window is not the first window with the sum of target
               if(start > 0 && best[start - 1] != Integer.MAX_VALUE){
               
                   //current sliding window has the length of i - start + 1                   
                   //previous shortest sliding window has the length of best[start - 1]
                   
                   ans = Math.min(ans, best[start - 1] + i - start + 1);
               }
               
               //to get the shortest length up to i
               bestSoFar = Math.min(bestSoFar, i - start + 1);
           }
           
           best[i] = bestSoFar;
       }
        System.out.println(Arrays.toString(best));
        
       return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}