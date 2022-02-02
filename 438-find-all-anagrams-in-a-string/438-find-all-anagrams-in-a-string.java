class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list= new ArrayList();
        
        
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return list;
        }
        if (s.length() == p.length() && isAnagram(s, p)) {
            list.add(0);
            return list;
        }
        
        
       int i = 0 , j =p.length();
        
        while(j<=s.length())
        {
            
            if(isAnagram(s.substring(i,j),p))
            {
                list.add(i);
            }
            
            i++;
            j++;
        }
        
        
        return list;
    }
    
    boolean isAnagram(String a,String b){
        
        
        int  arr[]=new int[26];
        for(int i=0;i<a.length();i++)
        {
            arr[a.charAt(i)-'a']++;
            arr[b.charAt(i)-'a']--;
        }
        
        
        for(int i=0;i<26;i++)
            if(arr[i]!=0)
                return false;
        
        return true;
        
    }
}