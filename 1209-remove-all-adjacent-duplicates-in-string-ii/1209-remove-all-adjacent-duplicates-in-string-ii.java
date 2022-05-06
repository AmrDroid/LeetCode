class Solution {
    public String removeDuplicates(String s, int k) {
        
        
        Stack<Pair> stack=new Stack();
        
        
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            
            if(!stack.isEmpty()&&stack.peek().c==s.charAt(i))
            {
                stack.peek().count++;
                if(stack.peek().count==k)
                    stack.pop();
            }
            else
            {
                stack.push(new Pair(s.charAt(i)));
            }
            
        }
        StringBuilder sb=new StringBuilder();
        
        for(Pair c: stack)
               sb.append(String.valueOf(c.c).repeat(c.count));
    
        return sb.toString();
    
    }
    
    
    
    class Pair{
        int count;
        char c;
        
     public Pair(char c){
            this.c = c;
            count = 1;
        }
    }
}