class Solution {
    public int maxSubArray(int[] nums) {
     
        int n=nums.length;
        int max_so_far=Integer.MIN_VALUE,max_end_here=0;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            max_end_here=max_end_here + nums[i];
            System.out.println(max_so_far+"  "+max_end_here);
               if (max_so_far < max_end_here)
           {
                max_so_far=max_end_here;
            }
            if(max_end_here<0)
            {
                max_end_here=0;
            }
        }
        
        return max_so_far;
    }
}