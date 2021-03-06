class Solution {
    public List<String> summaryRanges(int[] nums) {

     LinkedList<String> res = new LinkedList<>();
       
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        int left = 0;
        for (int i = 1; i < len + 1; i++) {
            
            if (i == len || nums[i] != nums[i - 1] + 1) {
                if (i - 1 == left) {
                    res.add(String.valueOf(nums[left]));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[left]).append("->").append(nums[i - 1]);
                    res.add(sb.toString());
                }
                left = i;
            }
        }

        return res;
    
    }
}