class Solution {
    public int characterReplacement(String string, int k) {
        
       
        Map<Character, Integer> characterCount = new HashMap<>();
        
        int result = 0;
        
        int windowStart = 0;
        int max=0;
        
        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
        
            char end = string.charAt(windowEnd);
            
            characterCount.put(end, (characterCount.getOrDefault(end, 0) + 1));
            
            max= Math.max(max,characterCount.get(end));
            
            while ((windowEnd - windowStart + 1) - max > k) {
                char startChar = string.charAt(windowStart);
                characterCount.put(startChar, characterCount.get(startChar) - 1);
                windowStart = windowStart + 1;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
        
    }
    int max(   Map<Character, Integer> count)
    {
        
        int max=0;
        for(Character c: count.keySet())
        {
            max=Math.max(max,count.get(c));
            
        }
        
        return max;
        
        
    }
}