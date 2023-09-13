class Solution {
    public int countBinarySubstrings(String s) {
        
        int curr=1,prev=0,i=1;
        
        int count =0;
        while(i<s.length())
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                count+=Math.min(curr,prev);
                prev=curr;
                curr=1;
            }
            else
            {
                curr++;
            }         
            i++;
        }
                        count+=Math.min(curr,prev);
        return count;
    }
}