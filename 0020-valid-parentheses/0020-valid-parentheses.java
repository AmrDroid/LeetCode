class Solution {
    public boolean isValid(String str) {
          Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
                continue;
            }
            if(s.isEmpty())return false;
            
            char c = s.pop();

            switch (ch) {

                case ')': {
                    if (c == '{' || c == '[')
                        return false;
                    break;
                }
                case ']': {
                    if (c == '{' || c == '(')
                        return false;
                    break;
                }
                case '}': {
                    if (c == '(' || c == '[')
                        return false;
                    break;
                }
            }
        }
        return s.isEmpty();
    }
}