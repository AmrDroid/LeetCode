class Solution {
    public int splitArray(int[] nums, int m) {
    
    
        int max=0, sum=0;
        for(int num : nums)
        {
            sum+=num;
            max=Math.max(num,max);
        }
        
        long l =max,r=sum;
        
        while(l<=r)
        {
            long mid = (l+r)/2;
            
            
            if(valid(mid,nums,m))
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return (int)l;
    }
    
    boolean valid(long target,int nums[],int m)
    {
        long count =0;
        
        int n=1;
        
        for(int num :nums)
        {
            count +=num;
            
            if(count>target)
            {

                count=num;
                n++;
                
                if(n>m)
                    return false;
                
            }
        
            
        }
        
        
        
        
        return true;
    }
    
}