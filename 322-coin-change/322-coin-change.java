class Solution {
int ans=Integer.MAX_VALUE;
    
    public int coinChange(int[] coins, int amount) {
         int[]amounts = new int[amount+1];
       
        Arrays.fill(amounts,amount+1);
        
        Arrays.sort(coins);
        
        int len = coins.length;
        
        amounts[0]=0;
        
        for(int i=1;i<=amount;i++)
        {
        
         for(int coin : coins)
         {
             if(i-coin>=0)
                 amounts[i]=Math.min(amounts[i],amounts[i-coin]+1);             
     
         }            
        }
        System.out.println(Arrays.toString(amounts));
     
        
        return amounts[amount]==amount+1? -1:amounts[amount];
        
    }
}