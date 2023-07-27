class Solution {

    
    HashMap<Integer, List<Integer>> map = new HashMap();
    
    public Solution(int[] nums) {
    
        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int size = list. size();
        int randIdx = new Random(). nextInt(size);
        return list.get(randIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */