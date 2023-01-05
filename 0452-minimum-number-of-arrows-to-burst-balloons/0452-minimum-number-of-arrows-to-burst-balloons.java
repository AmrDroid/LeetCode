class Solution {
    public int findMinArrowShots(int[][] points) {
        
        
        Arrays.sort(points, (a,b)->a[0]>b[0]? 1:-1);
        
        int count=1;
        
        int end=points[0][1];
        
        for(int i=1;i<points.length;i++){
            int [] point = points[i];
            if(point[0]>end){
                end=point[1];
                count++;
            }else{
                end = Math.min(end, point[1]);
            }
        }
        
        
        return count;
    }
}