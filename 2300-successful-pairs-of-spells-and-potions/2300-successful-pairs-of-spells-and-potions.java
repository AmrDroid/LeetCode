class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
       
        int n = spells.length;
        int m = potions.length;
        
        
        Arrays.sort(potions);
        int res[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            
            int l=0;
            int h=m;
            
            while(l<h)
            {
                int mid = (l+h)/2;
                if((long)spells[i]*(long)potions[mid]>=success)
                {
                    h=mid;
                }
                else
                    l=mid+1;                                
            }
            
            res[i]= m-l;

        }
        
        return res;
    }
}