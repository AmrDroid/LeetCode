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
        
        
        
        /*
        
          
         if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0]; // the minimum price from the first day to day k-1
        int[] first = new int[prices.length];
        // the maximum profit with at most one transaction from the first day to day k
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            first[i] = maxProfit;
            minPrice = Math.min(minPrice, prices[i]);
        }
       
        maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, first[i] );
        }
        return maxProfit;
        
        
        */
        
    }
}