class Solution {
    public String removeStars(String s) {
        
        Stack<Character> st=new Stack();
        
        String res="";
        for(int i=0;i<s.length();i++)
        {
            
            if(s.charAt(i)=='*'&&!s.isEmpty())
            {
                st.pop();                
            }
            else
            {
                st.push(s.charAt(i));
            }
            
        }
        
        while(!st.isEmpty())
            res= st.pop()+res;
        
        
        return res;
        
        
    }
}