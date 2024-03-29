class Solution {
    
public boolean isScramble(String s1, String s2) {
    if (s1.length() != s2.length()) {
        return false;
    }
    if (s1.equals(s2)) {
        return true;
    }

    Map<String, Boolean> memo = new HashMap<>();

    return isScrambleHelper(s1, s2, memo);

}

        private boolean isScrambleHelper(String s1, String s2, Map<String, Boolean> memo) {
            if (s1.length() != s2.length()) {
            return false;
            }
        
            if (s1.equals(s2)) {
            return true;
            }
            
            
            if (memo.containsKey(s1 + "#" + s2)) 
                return memo.get(s1 + "#" + s2);

            
            int n = s1.length();
            
            
            for (int i = 1; i < n; i++) 
            {
                
                if (isScrambleHelper(s1.substring(0, i), s2.substring(0, i), memo) 
                    &&
                    isScrambleHelper(s1.substring(i), s2.substring(i), memo)) 
                {
                    memo.put(s1 + "#" + s2, true); 
                    return true;
                } 
                
                if (isScrambleHelper(s1.substring(0, i), s2.substring(n-i), memo) 
                    &&
                    isScrambleHelper(s1.substring(i),s2.substring(0, n-i), memo)) 
                
                { 
                    memo.put(s1 + "#" + s2, true); return true; 
                
                } 
            
            } 
            
            memo.put(s1 + "#" + s2,false); 
            return false;     
                
        } 


}