class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       
      	//if we get a newInterval we can face three situations
        List<int[]> ans = new ArrayList<>();
        
        for(int[] interval: intervals){//for each interval
            if(interval[1] < newInterval[0]){//if our new interval is after current so we add current first
                ans.add(interval);
            }else if(interval[0] > newInterval[1]){//if our new interval is before current then add new interval first and make current interval new one
                ans.add(newInterval);
                newInterval = interval;
            }else{
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }//if new interval falls in between then update it
        }
        ans.add(newInterval);//last new interval added
        int[][] finalAns = new int[ans.size()][2];
        int i = 0;
        for(int[] a: ans){
            finalAns[i] = a;
            i++;
        }
        return finalAns;
    }

}
