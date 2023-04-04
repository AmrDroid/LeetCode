class Solution {
    public int partitionString(String s) {
        
        Set<Character> set= new HashSet();
        
        
        int n = s.length();
        
        int res=1;
        
        for(int i=0;i<n;i++)
        {
            char c= s.charAt(i);
            if(set.contains(c))
            {
                set.clear();
                set.add(c);
                res++;
            }
            else
            {
                set.add(c);
            }
            
            
        }
        
        return res;
        
    }
}