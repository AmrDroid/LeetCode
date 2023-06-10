class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
           
        int left = index, right = index;
        
        int ans = 1;
        
        maxSum -= n;

        while(true) {
        
            if(left == 0 && right == n - 1) {
                ans += maxSum / n;
                break;
            }

            maxSum -= (right - left + 1);
            
            if(maxSum >= 0) {
            
                ans += 1;
                left = left - 1 > 0 ? left - 1 : 0;
                
                right = right + 1 < n ? right + 1 : n - 1;
            
            }
            else break;
        }

        return ans;
        
    }
}