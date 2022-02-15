class Solution {
    public int singleNumber(int[] nums) {
 
          int num = 0;
    
        for(int i=0; i<nums.length; i++){
            num ^= nums[i]; 
        }
        
        return num;
        
        
        
        /*     Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Integer i : map.keySet())
        {
            if(map.get(i)==1)
                return i;
        }
            
    return -1;
    */
    }
}