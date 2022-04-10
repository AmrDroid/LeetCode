class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s= new Stack();
        
        int score=0;
        
        for(String op : ops)
        {
            if(op.equals("C"))
            {
                
                if(s.size()>=1)
                    s.pop();
                
            }
            else if(op.equals("D"))
            {
                if(s.size()>=1)
                {
                   int top=  s.peek();
                   s.push(top*2);                    
                }
            }
            else if(op.equals("+"))
            {
                if(s.size()>=2)
                {
                    int size=s.size();
                    
                    int fir=  s.get(size-1);
                    int sec= s.get(size-2);                    
                    s.push(fir+sec);
                }
            }
            else
            {
                s.push(Integer.parseInt(op));
            }
                
        }
        
        while(!s.isEmpty())
            score+=s.pop();
        
        return score;
        
    }
}