class Solution {
    public String reformat(String s) {
        
        int countAlpha=0;
        int countLetter=0;
        
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
                countLetter++;
            else
                countAlpha++;            
        }
        boolean check=false;
        
        if (countAlpha==countLetter || countAlpha==countLetter+1 || countLetter == countAlpha+1) 
            check = true;
        
        
         if (check) {
            char[] c = s.toCharArray();
         
            String newStr = "";
            int i=0;
            
            Stack <Character> st = new Stack<>();
            Stack <Character> stLet = new Stack<>();
            
             while (i<c.length) {
                 
                if (Character.isDigit(c[i])) {
                    st.push(c[i]);
                }
                else {
                    stLet.push(c[i]);
                }
                i++;
            }
            for (int j=0;j<c.length;j++) {
                
                if (countLetter == countAlpha+1) {
                    
                    if (j%2==0 && !st.isEmpty()) 
                            newStr+= st.pop();
                    else 
                            newStr+= stLet.pop();
                    
                }
                
                else  {
                
                    if (j%2==1 && !st.isEmpty()) 
                        newStr+= st.pop();
                    else
                        newStr+= stLet.pop();
                
                }
                
            }
             
            return newStr;
        } 
        
        return "";
        
        
    }
}