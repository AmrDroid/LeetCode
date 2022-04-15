class Solution {
    public int change(int amount, int[] coins) {
        
        int noOfWays[]=new int[amount+1];
        
        
        Arrays.fill(noOfWays,0);
        
        noOfWays[0]=1;
        for(int coin : coins)
        {
            for(int target= 1;target<=amount;target++)
            {
                if(target>=coin)
                    noOfWays[target] += noOfWays[target-coin];
            }
        }
        
        return noOfWays[amount];
    }
}