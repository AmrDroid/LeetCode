class Solution {
    public int majorityElement(int[] nums) {
        
        int n= nums.length;
        
        Map<Integer,Integer> m=new HashMap();
        
        for(int i : nums)
        {
            m.put(i,m.getOrDefault(i,0)+1);
        }
        
        for(Integer i  : m.keySet())
        {
            if(m.get(i)>n/2)
                return i;
        }
        return -1;
    }
}