class Solution {
    public int findLUSlength(String a, String b) {
     
        if(a.length()<b.length())
        {
            String t=a;
            a=b;
            b=t;
        }
       
        return issubsequence(a,b) == true ? -1:a.length();
    }
    
    public boolean issubsequence(String s1 , String s2){
        int i = 0;
        int j = 0;
        while(i<s1.length() && j < s2.length()){                  //simpe subsequence check
            if(s1.charAt(i) == s2.charAt(j++)){
                i++;
            }
        }
        return i == s1.length();
    }
        
}