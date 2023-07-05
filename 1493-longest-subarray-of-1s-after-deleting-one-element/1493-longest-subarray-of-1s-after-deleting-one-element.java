class Solution {
    public int longestSubarray(int[] nums) {
         
        // To Store Current 1 Count
        int curr = 0;

       // To Store Previous 1 Count
        int prev = 0;

       // To Check Weather a 0 is present or not either use boolean
        int zero = 0;

      // To Store Maximum 1 count
        int max = 0;

        //Iterate over the array
        for(int t : nums)
        {
          // If we get a 1 then increment the current 1 count
           if( t == 1) curr++;

          // If we get a 0 then get max from max and prev + curr
           else
           {
             max = Math.max( max , prev + curr );
             prev = curr;
             curr = 0;
             zero++;  
           }
        } 

        // If the last value is 1 for that case
        max = Math.max( max , prev + curr );

        // If there is no 0 in the array
        if(zero == 0) return max-1; 

       // return max
        return max;
    }
}