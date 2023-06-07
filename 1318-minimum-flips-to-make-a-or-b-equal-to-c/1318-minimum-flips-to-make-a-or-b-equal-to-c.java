class Solution {
    public int minFlips(int a, int b, int c) {
         
        int count = 0;
        
        while(a!=0 || b!=0 || c!=0){
            int abit = a&1, bbit = b&1, cbit = c&1;
            
            int num = 4*abit + 2*bbit + cbit;
            
            if(num == 1 || num == 2 || num == 4) count++;
            
            if(num == 6) count+=2;
            
            a>>=1; b>>=1; c>>=1;
        }        
        
        return count;
    }
}