class Solution {
    public boolean makeEqual(String[] words) {
        
        Map<Character , Integer> m=new HashMap();

        int n=words.length;
        for(String s:words)
        {
            for(Character c: s.toCharArray())
                m.put(c,m.getOrDefault(c,0)+1);
        }

        for(Character c : m.keySet())
        {
            if(m.get(c)%n!=0)
                return false;
        }
        
        
        
        
        return true;
        
    }
}