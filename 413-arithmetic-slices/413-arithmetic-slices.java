class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        
        if(n<3)return 0;
        
        int sum=0;
        int res=0;
        for(int i=2;i<n;i++)
        {
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                res++;
                sum+=res;
            }
            else
            {
                res=0;
            }
        }
    return sum;    
    }
}