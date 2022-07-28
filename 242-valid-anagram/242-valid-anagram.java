class Solution {
    public boolean isAnagram(String s, String t) {
         if(s.length()!=t.length())return false;
        int res[]=new int[256];  
       
        for(int i=0;i<s.length();i++)
        {
            res[s.charAt(i)-'a']++;
            res[t.charAt(i)-'a']--;
        }
        System.out.println(Arrays.toString(res));
        for(int i=0;i<res.length;i++)
            if(res[i]!=0)return false;
        
        return true;
        
        
    }
}