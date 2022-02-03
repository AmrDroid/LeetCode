class Solution {
    public int findPeakElement(int[] nums) {
        int peek=nums[0];
        int index=0;
        int n=nums.length;
        if(n==0)return -1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>peek)
            {
                peek=nums[i];
                index=i;
            }
        }
        
        return index;
    }
}