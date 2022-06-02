class Solution {
    public int partitionDisjoint(int[] nums) {
        
        
        int leftmax = nums[0], greater = nums[0], n = nums.length, ans = 0;
        
        for(int i=1;i<n;i++){
            if(nums[i] > greater){
                greater = nums[i];
            }
            if(nums[i] < leftmax){
                ans = i;
                leftmax = greater;
            }
        }
        return ans+1;
        
    }
}