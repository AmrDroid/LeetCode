class Solution {
 static final int[] vowels = {
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,
            0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0 };
          //  a b c d e f g h i j k l m n o p q r s t u v w x y z

    public int maxVowels(String s, int k) {
        char[] sc = s.toCharArray();
        
        // Fill the initial window of length k.
        int vowelCount = 0;
        for (int i = 0; i < k; i++)
            vowelCount += vowels[sc[i]];
        
        int maxVowelCount = vowelCount;
        
        // Slide the window right one character at a time, 
        // adding and removing vowels as the window slides 
        // each character position.
        int left = 0;
        for (int i = k; i < sc.length; i++) {
            vowelCount += vowels[sc[i]] - vowels[sc[left++]];
            maxVowelCount = Math.max(maxVowelCount, vowelCount);
        }
        return maxVowelCount;
    }
}