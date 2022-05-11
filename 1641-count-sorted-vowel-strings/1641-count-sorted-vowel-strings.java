class Solution {
    public int countVowelStrings(int n) {
     
        int[] endWith = new int[]{1, 1, 1, 1, 1}; // this counts how many strings ends with a, e, i, o and u, initialized for strings with length 1        
     
        for (int i = 2; i <= n; i++) { // build strings with length i, count how many strings ends with each char, by adding 1 char after previous endWith list (strings with -1 length)        
            for(int j=1;j<5;j++)
                endWith[j]+=endWith[j-1];          
        }
        
        return endWith[0] + endWith[1] + endWith[2] + endWith[3] + endWith[4]; // add up all string counts
   
    }
}