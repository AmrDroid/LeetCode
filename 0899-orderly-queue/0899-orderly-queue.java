class Solution {
    public String orderlyQueue(String s, int k) {
          if(k > 1){
              
            char ss[]=s.toCharArray();  
            Arrays.sort(ss);
            String nS=new String(ss);              
            return nS;
        }
        String s_min = s;
        for(int i = 0; i < s.length(); ++i){
            s = s.substring(1) + s.charAt(0);
            
            if(s_min.compareTo(s)>0)
                s_min=s;
        }
        return s_min;
    }
}