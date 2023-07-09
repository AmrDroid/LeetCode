class Solution {
    public int largestVariance(String s) {
        
           
        int ans=0;
        
        HashMap<Character,Integer> mp=new HashMap<>();
        
        for(char ch:s.toCharArray()){
           mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        
        
        for(char ch1='a';ch1<='z';ch1++){
            for(char ch2='a';ch2<='z';ch2++){
                if(ch1==ch2 || mp.getOrDefault(ch1,0)==0 ||mp.getOrDefault(ch2,0)==0)
                    continue;
                
                for(int rev=0;rev<2;rev++){
                    
                    int cnt1=0,cnt2=0;
                    
                    for(char c:s.toCharArray()){
                        if(c==ch1)
                        cnt1++;
                    
                        if(c==ch2)
                        cnt2++;
                        
                        if(cnt1<cnt2)
                        cnt1=cnt2=0;
                        
                        if(cnt1>0 &&cnt2>0)
                        ans=Math.max(ans,cnt1-cnt2);
                    }
                    
                  s=new StringBuilder(s).reverse().toString();
                }
            }
        }
        return ans;
        
    }
}