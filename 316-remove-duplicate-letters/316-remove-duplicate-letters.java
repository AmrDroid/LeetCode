class Solution {
    public String removeDuplicateLetters(String s) {
         if (s == null || s.length() < 2) return s;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        //Stack<Integer> stack = new ArrayDeque<Integer>();
        Set<Character> set = new HashSet<Character>();
        
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            if (!set.contains(c)) {
                //while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > 0) {
                int idx;
                char last;
                while (res.length() > 0 
                       && c < (last = res.charAt(idx = res.length() - 1))  
                       && map.get(last) > 0) {
                  
                    set.remove(last);
                    res.deleteCharAt(idx);
                }
                //stack.push(c);
                res.append(c);
                set.add(c);
            }
            map.put(c, map.get(c) - 1);
        }
        return res.toString();
        
    }
}