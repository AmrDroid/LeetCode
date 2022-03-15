class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int close =0;
        int openClose=0;
        
        int n = s.length();
        for(int i=0;i<n;i++)
            if(s.charAt(i)==')')close++;
        StringBuilder sb=new StringBuilder();
        System.out.println(close);
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            
            if(c=='(')
            {
                if(openClose==close)continue;
                openClose++;
            }
            if(c==')')
            {
                close--;
                if(openClose==0)continue;
                openClose--;
            }
            
            
            sb.append(c);

        }
        return sb.toString();
    }
}