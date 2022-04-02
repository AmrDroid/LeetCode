class Solution {
     int ans = Integer.MIN_VALUE;
    
    public boolean hasDup(String s) {
        Set<Character> hs = new HashSet();
        for(int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));
        }
        if(hs.size() == s.length()) {
            return false;
        }
        return true;
    }
    
    public void backTracking(String cur_s,int index,int n, String[] strs) {
        
        ans = Math.max(ans, cur_s.length());
        
        String new_s = "";
        
        for(int i = index; i < n; i++) {
        
            new_s = cur_s + strs[i];
            
            if(!hasDup(new_s)) {
            
                backTracking(new_s,i,n,strs);
            
            }
        }
    }
    
    public int maxLength(List<String> arr) {
        
        String strs[] = arr.toArray(new String[0]);
        
        backTracking("",0,strs.length,strs);
        
        return ans;
    }
}