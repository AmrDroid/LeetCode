class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);
        int res=0;
        System.out.println(Arrays.toString(costs));
        for(int i=0;i<costs.length;i++)
        {
            if(coins>0&&coins>=costs[i])
            {
                res++;
                coins-=costs[i];
            }
        }
        
        return res;
    }
}