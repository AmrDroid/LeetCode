class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> res=new ArrayList<>();
        
        List<Integer> res1=new ArrayList<>(),res2=new ArrayList<>();
        
        Map<Integer,Integer> m=new HashMap<>();
        
        for(int i:nums1)
            m.put(i,0);
        
        for(int i:nums2){
            if(!m.containsKey(i))   
                res2.add(i);
            m.put(i,2);
        }
        
        for(int i:m.keySet())    
            if(m.get(i)==0)     
                res1.add(i);   
        
        res.add(res1);
        res.add(res2);  
        
        return res;
    }
}