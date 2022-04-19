class Solution {
    public int minAreaRect(int[][] points) {
         // Write your code here.
        
    Map<String, Boolean> pointsMap = getPointsMap(points);

        int minArea = Integer.MAX_VALUE;

    for (int i = 0; i < points.length; i++) {
        
      int p1x = points[i][0], p1y = points[i][1];

       for (int j = 0; j < i; j++) {
      
          int p2x = points[j][0], p2y = points[j][1];
           
          boolean areInvalidPoints = p1x == p2x || p1y == p2y;

          if (areInvalidPoints) continue;

          String p3 = toStr(p1x, p2y), p4 = toStr(p2x, p1y);

    
          if (pointsMap.containsKey(p3) && pointsMap.containsKey(p4)) {
              
              int currentArea = area(p1x, p2x, p1y, p2y);
              minArea = Math.min(minArea, currentArea);
        
          }
      }
    }

    return minArea == Integer.MAX_VALUE ? 0 : minArea;
  }

  private Map<String, Boolean> getPointsMap(int[][] points) {
      
    Map<String, Boolean> map = new HashMap<>();
    for (int[] point : points) map.put(toStr(point[0], point[1]), true);
    return map;
  }

  private String toStr(int x, int y) {
    return x + "," + y;
  }
    
    private int area(int x1, int x2, int y1, int y2) {
    return Math.abs(x1 - x2) * Math.abs(y1 - y2);
  }
}