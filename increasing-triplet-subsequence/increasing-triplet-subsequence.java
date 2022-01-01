class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        
        int min=Integer.MAX_VALUE,sec_min=Integer.MAX_VALUE;
        
        for(int num : nums)
        {
            if(num<=min)
                min=num;
            else if(num<=sec_min)
                sec_min=num;
            else
                return true;
            
        }
        
        return false;
    }
}