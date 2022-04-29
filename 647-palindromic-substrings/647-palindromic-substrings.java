class Solution {
    public int countSubstrings(String str) {
      int n = str.length();
         int res=0;
        boolean table[][] = new boolean[n][n];
        for (int i = 0; i < n; ++i){
            table[i][i] = true;
            res++;
        }
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                res++;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                 if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    res++;                 
                }
            }
        }

       return res;
    }
}