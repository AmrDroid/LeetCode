class Solution {
    
    
      public int maxProduct(String[] words) {
        int n = words.length;
        int[] word_int = new int[n];
        int[] word_len = new int[n];
      
          for(int i = 0; i < n; ++i){
          
              String w = words[i];
              int _len = w.length();
              int w_int = 0;
              
              for(int j = 0; j < _len; ++j)
                  w_int |= 1 << (w.charAt(j) - 'a');
            
              word_int[i] = w_int;
              word_len[i] = _len;
        }
        
        int max_product = 0;
        for(int i = 0; i < n-1; ++i){
            for(int j = i+1; j < n; ++j){
                if((word_int[i] & word_int[j]) == 0)
                    max_product = Math.max(max_product, word_len[i]*word_len[j]);
            }
        }
        return max_product;
    }
    
    
   /* public int maxProduct(String[] words) {

        Set set=new HashSet<>(); //Create Set for storing String Element
        int n=words.length;
        int max=0; // Create max for return(store value in it)


        

        for(int i=0;i<n-1;i++){                           // For accessing ith string from string array
       
           String s1=words[i];
           int s1length=s1.length();
            
            for(int k=0;k<s1length;k++)        // ith string elements add to set 
                 set.add(s1.charAt(k));
                
            for(int j=i+1;j<n;j++){                      // for accessing i+1 to n string (Used for comparing with ith string)
            
                String s2=words[j];
            
                int s2length=s2.length();
              
                int m=0;
                
                 while(m<s2.length())
                 {              
                     if(set.contains(s2.charAt(m)))   // Check for jth string element present or not in ith string
                         break;
                     m++;
                 }
                
                 if(m==s2length)                               //  Condition for  jth string element not present in ith string
                     max=Math.max(max,s1length*s2length);   
        }
            
        set.clear();                                         // clear set because now we will compare new ith element 
    }
        
    return max;
    }*/
}