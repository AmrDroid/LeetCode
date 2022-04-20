class Solution {
    public int minCut(String str) {
    
    int len = str.length();
    
    boolean[][] palindromes = createPalindromeArray(str);

    int[] minCuts = new int[len];
    
    Arrays.fill(minCuts, Integer.MAX_VALUE);

    for (int i = 0; i < len; i++) {
        
      if (palindromes[0][i]) minCuts[i] = 0;

      else {
      
          minCuts[i] = minCuts[i - 1] + 1;

          for (int j = 1; j < i; j++)
              if (palindromes[j][i] && minCuts[i] > minCuts[j - 1] + 1) minCuts[i] = minCuts[j - 1] + 1;
      
      }
    }

    return minCuts[len - 1];
  }

  private static boolean[][] createPalindromeArray(String s) {
    int len = s.length();
    boolean[][] palindromes = new boolean[len][len];

    for (int i = 0; i < len; i++) palindromes[i][i] = true;

    for (int length = 2; length < len + 1; length++) {
      for (int i = 0; i < len - length + 1; i++) {
        int j = i + length - 1;

        if (length == 2) palindromes[i][j] = s.charAt(i) == s.charAt(j);
          
        else 
            palindromes[i][j] = s.charAt(i) == s.charAt(j) && palindromes[i + 1][j - 1];
          
      }
    }

    return palindromes;
  }
}