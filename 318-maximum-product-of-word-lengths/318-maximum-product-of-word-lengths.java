class Solution {
    public int maxProduct(String[] words) {

        Set set=new HashSet<>(); //Create Set for storing String Element
        int n=words.length;
        int max=0; // Create max for return(store value in it)


        

        for(int i=0;i<n-1;i++){                           // For accessing ith string from string array
        
            for(int j=i+1;j<n;j++){                      // for accessing i+1 to n string (Used for comparing with ith string)
            
 
                String s1=words[i];
                String s2=words[j];
                
                int s1length=s1.length();
                int s2length=s2.length();
            
                for(int k=0;k<s1length;k++)        // ith string elements add to set 
                    set.add(s1.charAt(k));
                
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
    }
}