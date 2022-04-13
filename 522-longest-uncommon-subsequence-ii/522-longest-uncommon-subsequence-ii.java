class Solution {
    public int findLUSlength(String[] strs) {
   
        
        Arrays.sort(strs,new Comparator<String>(){
            public int compare(String s1,String s2)
            {
                return s2.length()-s1.length();
            }
        });
        
        int n = strs.length;
        
        for(int i=0;i<n;i++)
        {
            
            boolean flag = false;
            
            for(int j=0;j<n;j++)
            {
                
                if(i!=j && isSubsequence(strs[i],strs[j]))
                {
                    flag=true;
                    break;
                }            
            }
            if(!flag)
            {
                return strs[i].length();
            }
            
        }
        return -1;
    }
    
    public boolean isSubsequence(String a,String b)
    {
        int i=0,j=0;
        while(i<a.length()&&j<b.length())
        {
            if(a.charAt(i)==b.charAt(j++))
                i++;
        }
        return i==a.length();
    }
        
}