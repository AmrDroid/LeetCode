class Solution {
    public int totalMoney(int n) {
        
        int res=0; 
       
        if(n<7)
        {
            while(n>0){
                res+=n;
                n--;
                }
            return res;
        }
        int rem=n%7;
        
        int week=28;
        int size= (n-rem)/7;
        
        
        int s=size;
        while(rem>0)
        {
            s++;
            res+=s;
            rem--;
        }
        
        if(size>1)
        {
            while(size>0)
            {
                res+=week;
                week+=7;
                size--;
            }
        }
        else
            res+=week;
        
        return res;
    }
}