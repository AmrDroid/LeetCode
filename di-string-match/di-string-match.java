class Solution {
    public int[] diStringMatch(String S) {
        
        
        int[] res = new int[S.length() + 1];
        
        int end = res.length - 1,
        
        start = 0;
        
        int index = 0;
    
        while(index < S.length()){
            
            if(S.charAt(index) == 'I'){
            
                res[index] = start;   
                start++;
           
            }else{
                res[index] = end;
                end--;
            }
            index++;
        }
        res[res.length - 1] = start;//start or end all is true
        return res;
    }
}