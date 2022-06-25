class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int modifications = 0;
        
        // traversing the array 
        for(int i = 1 ; i < nums.length ; i++) {
            
            // comparing current and previous element
            // if current is less than previous, then modification needs to be done
          
            if(nums[i] < nums[i-1]) {

                // post incrementing the modifications count 
                // since atmost one modifications is allowed 
                if(modifications++ == 1) return false;
                    
                // if i >= 2 , then modifying depends on i-2 th element 
                if(i >= 2) {
                    
                    if(nums[i-2] > nums[i])  
                        nums[i] = nums[i-1];
                    else 
                        nums[i-1] = nums[i];
                }
                
            }
            
        }
        
        return true;
    }
}