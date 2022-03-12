class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
           Set<Integer> s=new HashSet();
        List<Integer> l=new ArrayList();
        for(int i:nums1)s.add(i);
        
        for(int i: nums2)
        {
            if(s.contains(i)&&!l.contains(i))
              l.add(i);
        }
        int res[]=new int[l.size()];
        for(int i=0;i<l.size();i++)
            res[i]=l.get(i);
            
        return res;
    }
}