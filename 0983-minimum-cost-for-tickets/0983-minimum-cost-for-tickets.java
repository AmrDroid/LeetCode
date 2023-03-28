class Solution {
    public int [] t;
    
    public int mincostTickets(int[] days, int[] costs) {
    
        t=new int[days.length+1];
        
        Arrays.fill(t,-1);
        
        return solve(days,costs,0);
    }
    public int solve(int [] days,int []costs,int ind){
        
        if(ind>=days.length) return 0;
        
        if(t[ind]!=-1) return t[ind];
        
        int day1=costs[0]+solve(days,costs,ind+1);
        
        int i=ind;
        
        for(;i<days.length && days[i]<days[ind]+7;i++){}
        
        int day2=costs[1]+solve(days,costs,i);
        
        i=ind;
        
        for(;i<days.length && days[i]<days[ind]+30;i++){}
        
        int day3=costs[2]+solve(days,costs,i);
        
        return t[ind]=Math.min(day1,Math.min(day2,day3));
    }
    
}