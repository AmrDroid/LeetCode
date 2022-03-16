class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
         if (pushed == null || popped == null || pushed.length == 0 || popped.length == 0) {
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(pushed[0]);
            int i = 1;
            int j = 0;
            while (!stack.isEmpty() || j < popped.length) {
                if (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                } else {
                    if (i < pushed.length) {
                        stack.push(pushed[i++]);
                    } else {
                        return stack.isEmpty();
                    }
                }
            }
            return stack.isEmpty();
        
        /*Stack<Integer> s=new Stack();
        int ind=0;

        for(int i:pushed) {    
            s.push(i);    
            while(!s.isEmpty()&&s.peek()==popped[ind])
            {
                s.pop();
                ind++;
            }
        }
        while(!s.isEmpty()&&ind<popped.length)
        {
            if(s.pop()!=popped[ind++])
                return false;
        }
        
        return s.isEmpty();
        */
    }
}