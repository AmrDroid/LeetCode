class Solution {
    
    int ans=0;
    public int maximumRequests(int n, int[][] nums) {
 
        int[] count = new int[n];
        
        solve(nums, n, count, 0, 0);
        
        return ans;
    }
    public void solve(int[][] nums, int n, int[] count, int index, int counta){
     
        
        if(index == nums.length){
            //checking if the subset is following the rule for swapping
            for(int i: count){
                if(i != 0){
                    return;
                }
            }
            ans = Math.max(counta, ans);
            return;
        }


        //Using backtracking approach
        count[nums[index][0]]--;
        count[nums[index][1]]++;
        
        solve(nums, n, count, index+1, counta+1);

        count[nums[index][0]]++;
        count[nums[index][1]]--;
        
        
        solve(nums, n, count, index+1, counta);

    } 
}