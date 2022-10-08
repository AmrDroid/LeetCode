class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
            int len = nums.length;
	        int d = Integer.MAX_VALUE;
	        Arrays.sort(nums);
	        for(int i = 0; i < len-2; i++){
	            if(i > 0 && nums[i-1] == nums[i]) continue;
	            int left = i+1; int right=len-1;
	            while(left < right){
	                int t = target - nums[i] - nums[left] - nums[right];
	                if(t == 0) return target;
	                else if(t > 0){
	                    if(Math.abs(t) < Math.abs(d))
	                        d = t;
	                    left++;
	                } 
	                else{
	                    if(Math.abs(t) < Math.abs(d))
	                        d = t;
	                    right--;
	                }
	            }
	        }
	        return target - d;
    }
}