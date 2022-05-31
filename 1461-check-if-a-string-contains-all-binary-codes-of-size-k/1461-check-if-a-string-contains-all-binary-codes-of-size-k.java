class Solution {
    public boolean hasAllCodes(String s, int k) {
     
        Set<String> set=new HashSet();
        int n = s.length();
        
        for(int i=0;i<n-k+1;i++)
        {            
            String sub = s.substring(i,i+k);
            set.add(sub);
        }
        System.out.println(set);
        return set.size() == Math.pow(2,k);
    }
}