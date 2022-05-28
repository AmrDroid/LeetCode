class Solution {
    public int missingNumber(int[] nums) {
           Set<Integer> s=new HashSet();
        
        for(int i : nums)
            s.add(i);
        int i=0;
        for( i=0;i<nums.length;i++)
            if(!s.contains(i))break;
        return i;
    }
}