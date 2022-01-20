class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int k=0;
        
        int n= piles.length;
        
        if(n==0)
            return 0;
        
        
        int maxPile=0;
        
        for(int pile :piles)
            maxPile=Math.max(pile,maxPile);
        
        
        int low=1,high=maxPile;
        
        while(low<=high)
        {
            
            int mid= (low+high)/2;
            int total=0;
            for(int pile : piles)
            {
                total+=(pile % mid == 0) ? pile / mid : pile / mid + 1;
            }

            if(total<=h)
            {
                k=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
            total=0;
            
        }
        
        return k;
        
    }
}