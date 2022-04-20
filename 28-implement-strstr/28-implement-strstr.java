class Solution {
    public int strStr(String haystack, String needle) {
        
        int n= haystack.length();
        int m = needle.length();
        if(n<m|| n==0 )return -1;
        if(m==0)return 0;
        
        int i=0,j=0;
        
        while(i<n)
        {
          
            int k=i; 
            while(j<m)
            {
                
                if(k>=n||haystack.charAt(k)!=needle.charAt(j))
                    break;
                k++;
                j++;
            }
                          
             if(j==m)
                 return i;
            i++;
            j=0;
            
            
        }
        
        return -1;
    }
}