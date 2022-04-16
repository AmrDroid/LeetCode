class Solution {
      private Map<Integer, String> hm = new HashMap<>(){{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    private void dfs(List<String> ans, String digits, int index, String cur)
    {
        
        if(index == digits.length())
        {
            ans.add(cur);
            return;
        }
        
        int id = digits.charAt(index)-'0';
        
        String s = hm.get(id);
        
        for(int i=0; i<s.length(); i++)
        {
            dfs(ans, digits, index+1, cur+s.charAt(i));
        }
    }
    
    public List<String> letterCombinations(String digits) {
       
        List<String> ans = new ArrayList<>();
       
        if(digits.length() == 0) return ans;
        
       
        dfs(ans, digits, 0, "");
       
        return ans;
    }
}