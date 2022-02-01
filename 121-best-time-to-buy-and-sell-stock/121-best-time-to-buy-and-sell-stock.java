class Solution {
    public int maxProfit(int[] prices) {
        
        int res=0;
        
        int prev=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prev)
            {
                
                res=Math.max(res,prices[i]-prev);
            }
            
            if(prices[i]<prev)
                prev=prices[i];
        }
        return res;
        
    }
}