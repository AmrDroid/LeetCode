class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n= strs.length;
        int len = strs[0].length();
        char arr[][]=new char[n][len];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<len;j++)
            {
                arr[i][j]=strs[i].charAt(j);
            }
        }
        
        int res=0;
        
        for(char a[]:arr)
                    System.out.println(Arrays.toString(a));
        
        // System.out.println(arr[0].length);
        
        for(int i=0;i<arr[0].length;i++)
        {

            char prev=arr[0][i];
            for(int j=1;j<arr.length;j++)
            {
                if(arr[j][i]<prev)
                {
                    res++;
                    //j++;
                break;  
                }
                prev=arr[j][i];        
            }
        }
        
        
        
        
        
        return res;
    }
}