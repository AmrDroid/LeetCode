class Solution {
    public int minDeletions(String s) {
        
            int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a'] ++;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : count) {
            if (num != 0) {
                while (num != 0 && set.contains(num)) {
                    res++;
                    num--;
                }
                set.add(num);
            }
        }
        //3.   2  
        //1. 
        
        return res;
        
        
        
    }
}