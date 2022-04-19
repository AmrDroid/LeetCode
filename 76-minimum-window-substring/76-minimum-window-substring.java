class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int required = t.length();
        int bestLeft = -1;
        int minLength = s.length() + 1;

        for (char c : t.toCharArray()) {
            count[c]++;
        }

        for (int l = 0, r = 0; r < s.length(); ++r) {
            if (--count[s.charAt(r)] >= 0) {
                --required;
            }

            while (required == 0) {
                int curSub = r - l + 1;
                if (curSub < minLength) {
                    minLength = curSub;
                    bestLeft = l;
                }

                if (++count[s.charAt(l++)] > 0) {
                    ++required;
                }
            }
        }

        return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft+minLength);
   
  }
}