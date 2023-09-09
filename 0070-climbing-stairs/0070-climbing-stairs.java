class Solution {
    public int climbStairs(int n) {
        
      int m=2;
    int res[] = new int[n + 1];
        int temp = 0;
        res[0] = 1;

        for (int i = 1; i <= n; i++) {
            int s = i - m - 1;              int e = i - 1;
            if (s >= 0) {
                temp -= res[s];
            }
            temp += res[e];
            res[i] = temp;
        }
        return res[n];
        
    }
}