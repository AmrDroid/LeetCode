class NumArray {

    
    int[] tree; 
    int[] numsCopy;  
    
    private void updateHelper(int idx, int diff) {
        while (idx <= numsCopy.length) {
            tree[idx] += diff;
            idx += (idx & -idx);
        }
    }
    
    private int cumulativeSum(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    public NumArray(int[] nums) {
        if (nums != null) {
            numsCopy = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
            tree = new int[nums.length + 1]; 
            for (int i = 0; i < nums.length; ++i) updateHelper(i + 1, nums[i]);
        }
    }

    void update(int i, int val) {
        updateHelper(i + 1, val - numsCopy[i]);
        numsCopy[i] = val;
    }

    public int sumRange(int i, int j) {
        return cumulativeSum(j + 1) - cumulativeSum(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */