class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
          Set<List<Integer>> result = new HashSet<>();
          List<List<Integer>> res = new ArrayList<>();
 if(nums == null || nums.length == 0) return res;
        backtrace(result, new ArrayList<>(), nums, new boolean[nums.length]);
       
        for(List<Integer> s: result)
            res.add(s);
        return res;
    }
    private void backtrace(Set<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else{
            for(int i = 0; i < nums.length; i++){
                if(!used[i]){
                    temp.add(nums[i]);
                    used[i] = true;
                    backtrace(result, temp, nums, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
        
}