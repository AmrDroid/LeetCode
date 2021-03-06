class Solution {
    public int calculate(String s) {
        
       Stack<Integer> stack = new Stack<>();
        
        int sign = 1;
        
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
        
            if (Character.isDigit(s.charAt(i))) {
            
                int num = s.charAt(i) - '0';
                
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    int next = s.charAt(i + 1) - '0';
                    num = num * 10 + next;
                    i++;
                }
                
                res += num * sign;
            } 
            
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            
            else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
        
    }
}