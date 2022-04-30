class Solution {
    public boolean checkValidString(String str) {
    
          int leftMin = 0, leftMax = 0;
        for (char ch: str.toCharArray()) {
            if (ch == '(') {
                leftMin++;
                leftMax++;
            }
            else if (ch == ')') {
                leftMin--;
                leftMax--;
            }
            else {
                leftMin--;
                leftMax++;
            }
            System.out.println(leftMin+"  "+leftMax);
            if (leftMax < 0) { // Means we encounter ) as a starting character or # of occurrences of ) is > (
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    
    }
}