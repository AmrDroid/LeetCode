class Solution {
    public int longestConsecutive(int[] nums) {
           
        
            if (null == nums || nums.length < 1) {
                return 0;
            }
            
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }
            
            
            int maxLength = 0;
            
            for (int i : nums) {
                
                if (!set.contains(i - 1)) {
                    int length = 1;
                    int j = i;
                    while (set.contains(j + 1)) {
                        j++;
                        length++;
                    }
                    maxLength = Math.max(maxLength, length);
                }
            }
        
            return maxLength;
    }
}