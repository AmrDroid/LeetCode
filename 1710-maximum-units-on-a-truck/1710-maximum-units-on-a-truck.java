class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (b, a) -> Integer.compare(a[1], b[1]));
        
        int res=0;
        int ind=0;
        
        while(truckSize>0)
        {
            if(boxTypes[ind][0]>0)
            {
               res+=  boxTypes[ind][1];
                boxTypes[ind][0]--;
                truckSize--;
            }
            else 
            {
                ind++;
                if(ind==boxTypes.length)break;                
            }
        }
        return res;
        
    }
}