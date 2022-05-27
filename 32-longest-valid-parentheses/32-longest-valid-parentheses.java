class Solution {
    public int longestValidParentheses(String s) {
       
        int left = 0, right = 0;
        int maxlength = 0;

        int n=s.length();
        for (int i = 0; i < n; i++) {
 
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
           if (left == right)
                maxlength = Math.max(maxlength,2 * right);
            else if (right > left)
                left = right = 0;
        }
 
        left = right = 0;
 
        for (int i = n - 1; i >= 0; i--) {
 
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                maxlength = Math.max(maxlength,2 * left);
 
            else if (left > right)
                left = right = 0;
        }
        return maxlength;
    }
}