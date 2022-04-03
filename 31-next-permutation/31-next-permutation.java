class Solution {
    public void nextPermutation(int[] nums) {
        
        
        int n = nums.length;
        
        if(n==1)
            return;
        
        int i=1;
        
        int lastInc = -1;
        
        while(i<n) {    //Find the peak of last ASC order
        
            if(nums[i]>nums[i-1])
            
                lastInc = i;

            i++;
        }
        
        if(lastInc==-1) {   //Check if array is DSC
            
            for(i=0;i<n/2;++i)
            {
                int temp = nums[i];
                nums[i]=nums[n-i-1];
                nums[n-i-1]=temp;
            }
            return;
        }
        //Find element in the range (nums[lastInc-1] to nums[lastInc]) to the right
        int mn = nums[lastInc];

        int index = lastInc;
        
        for(i=lastInc;i<n;++i) {
        
            if(nums[i]>nums[lastInc-1] && nums[i]<nums[index]) {
                index = i;
            }

        }
        int temp = nums[lastInc-1];
        nums[lastInc-1]=nums[index];
        nums[index]=temp;
        
        
        Arrays.sort(nums,lastInc,n);
        
    }
}