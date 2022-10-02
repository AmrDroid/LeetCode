class Solution {
   
   public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;

        int firstCount = 1;
        int secondCount = 1;
        
        for(int i = 1; i<s.length(); i++) {
            int oneDigit = s.charAt(i) - '0';
            int twoDigit = (s.charAt(i-1)-'0')*10 + oneDigit;
            int count = 0;
            if(oneDigit > 0) count += firstCount;
            if(twoDigit >= 10 && twoDigit <= 26) count += secondCount;
            secondCount = firstCount;
            firstCount = count;
        }

        return firstCount;
    }
}