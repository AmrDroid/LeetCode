class Solution {
    public boolean validPalindrome(String s) {
         if (s == null || s.length() == 0) return false;
        return isPalindrome(s, 0, s.length() - 1, false);
    }
    private boolean isPalindrome(String s, int left, int right, boolean flag) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (flag) {
                    return false;
                } else {
                    return isPalindrome(s, left + 1, right, true) || isPalindrome(s, left, right - 1, true);
                }
            }
            left++; right--;
        }
        return true;
    }
}