class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        
        int n = nums.length;
        
        long res=0;
        
       int count =0;
        
        int i=0;
        while(i<n)
        {
              count=0;          
            while(i<n&& nums[i]==0)
            {
                count++;
                res+=count;     
                i++;
            }

            i++;            
        }
        return res;
        
    }
}