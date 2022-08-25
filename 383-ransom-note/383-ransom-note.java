class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      
        Map<Character,Integer> m=new HashMap();
       
        for(int i=0;i<magazine.length();i++)
            m.put(magazine.charAt(i),m.getOrDefault(magazine.charAt(i),0)+1);

        for(int i=0;i<ransomNote.length();i++)
        {
            if(m.getOrDefault(ransomNote.charAt(i),0)==0)return false;
            
            m.put(ransomNote.charAt(i),m.getOrDefault(ransomNote.charAt(i),0)-1);

        }
        
        return true;
        
    }
}