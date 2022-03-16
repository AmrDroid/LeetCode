class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> s=new Stack();
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
    }
}