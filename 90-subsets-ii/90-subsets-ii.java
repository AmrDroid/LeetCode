class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> res = new ArrayList<List<Integer>>();

        backtracking(nums, 0, new ArrayList<Integer>(), res);
        return res;
        
    }
    
    private void backtracking(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(temp));
        
        for (int i = start; i < nums.length; i++) {
             if(i != start && nums[i] == nums[i - 1]){  
                continue;
            }
            temp.add(nums[i]);
            backtracking(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}