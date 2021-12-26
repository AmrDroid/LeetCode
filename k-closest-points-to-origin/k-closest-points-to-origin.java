class Solution {
    public int[][] kClosest(int[][] pts, int k) {
       
       int n = pts.length;
    int[] distance = new int[n];
    for(int i = 0; i < n; i++)
    {
        int x = pts[i][0], y = pts[i][1];
        distance[i] = (x * x) + (y * y);
    }
 
    Arrays.sort(distance);
     int res[][]=new int[k][2];
    // Find the k-th distance
    int distk = distance[k - 1];
 
    // Print all distances which are
    // smaller than k-th distance
        int ind=0;
    for(int i = 0; i < n; i++)
    {
        int x = pts[i][0], y = pts[i][1];
        int dist = (x * x) + (y * y);
         
        if (dist <= distk)
        {
            res[ind][0]=x;
            res[ind][1]=y;
            ind++;
            System.out.println("[" + x + ", " + y + "]");
        }
        
    }
        return res;
}}