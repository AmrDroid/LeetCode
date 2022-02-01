class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
   
          
        int n = nums.length;
        List<Integer> ans=new ArrayList();
        if(n==0)
            return ans;
        if(n==1)
        {
            ans.add(nums[0]);
            return ans;
        }
        else if(n==2)
        {
            if(nums[1]%nums[0]==0)
            {
                ans.add(nums[0]);
                ans.add(nums[1]);
                return ans;
            }
            else
            {
                ans.add(nums[0]);
                return ans;
            }
        }
        Arrays.sort(nums);
       
        
        
        
        int max = 1;
        
        int dp[]=new int[nums.length];
        for(int i=1;i<n;++i)
        {
            for(int j=0;j<i;++j)
            {
                if(nums[i]%nums[j]==0 && 1 + dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                    if(max<dp[i])
                        max = dp[i];
                }
            }
        }
        //Now push the answer LIS
        int prev = -1;
        for(int i=n-1;i>=0;i--)
        {
            if(dp[i]==max &&  (prev%nums[i]==0 || prev==-1))
            {
                ans.add(nums[i]);
                max -=1;
                prev = nums[i];
            }
        }
        
        
        if(ans.size()==0)
            ans.add(nums[0]);
        
        
        return ans;
        
        
    }
}