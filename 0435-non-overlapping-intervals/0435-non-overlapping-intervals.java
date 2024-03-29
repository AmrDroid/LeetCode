class Solution {
    public int eraseOverlapIntervals(int[][] inte) {
       
        Arrays.sort(inte, Comparator.comparingDouble(o->o[1]));
        int count=1;
        int n = inte.length;
        int last = inte[0][1];
        for(int i=1; i<n; i++) {
            if(inte[i][0]>=last) {
                count++;
                last=inte[i][1];
            }
        }
        return n-count;
        
    }
}