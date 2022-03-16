class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> s=new Stack();
        
        int ind=0;
        for(int i:pushed) {
            
            s.push(i);
          //  System.out.println(Arrays.toString(s.toArray()));
            
            while(!s.isEmpty()&&s.peek()==popped[ind])
            {
        // System.out.println(s.peek()+"  >> "+ind);
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