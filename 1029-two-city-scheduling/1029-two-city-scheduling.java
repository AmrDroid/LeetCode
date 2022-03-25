class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n=costs.length;
        
        int diff[][]= new int [n][3];
        
        for(int i=0;i<n;i++)
        {
            int []cost= costs[i];
            diff[i][0]= cost[1]-cost[0];
            diff[i][1]=cost[0];
            diff[i][2]=cost[1];
        }
        
        Arrays.sort(diff,(a, b) -> Integer.compare(a[0],b[0]));
        int res=0;
        
        for(int i=0;i<n;i++)
        {
            if(i<n/2)
                res+=diff[i][2];
            else
                res+=diff[i][1];
            
        }
        return res;
    }
}