class Solution {
    public int maxPoints(int[][] points) {
          // Write your code here.
    int len = points.length, maxLines = 1;

    int max=0;
    for (int i = 0; i < len-max; i++) {
    
        int[] p1 = points[i];

        Map<String, Integer> slopes = new HashMap<>();

      for (int j = i + 1; j < len; j++) {
        int[] p2 = points[j];
          
        String slope = getHashedKey(calculateSlope(p1, p2));

        slopes.put(slope, slopes.getOrDefault(slope, 1) + 1);
      }

      maxLines = Math.max(maxLines, maxSlope(slopes));
        if(max>maxLines)
            max=maxLines;
    }

    return maxLines;
  }

  private String getHashedKey(int[] slope) {
    return slope[0] + "," + slope[1];
  }

  private int[] calculateSlope(int[] p1, int[] p2) {
   
    int p1x = p1[0], p1y = p1[1];
    int p2x = p2[0], p2y = p2[1];
    int[] slope = {1, 0};

    if (p1x != p2x) {
        
      int yDiff = p1y - p2y, xDiff = p1x - p2x;
      int gcd = computeGCD(Math.abs(yDiff), Math.abs(xDiff));

      yDiff /= gcd;
      xDiff /= gcd;

      if (xDiff < 0) {
        yDiff *= -1;
        xDiff *= -1;
      }

      slope = new int[] {yDiff, xDiff};
    }

    return slope;
  }

  private int computeGCD(int a, int b) {
    while (true) {
      if (a == 0) return b;

      if (b == 0) return a;

      int temp = a;
      a = b;
      b = temp % b;
    }
  }

  private int maxSlope(Map<String, Integer> map) {
    int max = -1;
    for (Map.Entry<String, Integer> entry : map.entrySet())
      max = Math.max(max, map.get(entry.getKey()));
    return max;
  }
}