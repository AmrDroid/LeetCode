class Solution {
    public int minDeletionSize(String[] strs) {
        
            
        int remove = 0;
        for(int i=0;i<strs[0].length();i++)
        {
            int max = 0;
            for(int j=0;j<strs.length;j++)
            {
                if(max==0)
                {
                    max = strs[j].charAt(i)-0;
                }
                if (strs[j].charAt(i)-0<max)
                {
                    remove+=1;
                    break;
                }
                else{
                    max = strs[j].charAt(i)-0;
                }
            }
        }
        return remove;
        
//         int n= strs.length;
//         int len = strs[0].length();
//         char arr[][]=new char[n][len];
        
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<len;j++)
//             {
//                 arr[i][j]=strs[i].charAt(j);
//             }
//         }
        
//         int res=0;
        
//         for(int i=0;i<arr[0].length;i++)
//         {

//             char prev=arr[0][i];
//             for(int j=1;j<arr.length;j++)
//             {
//                 if(arr[j][i]<prev)
//                 {
//                     res++;
//                   break;  
//                 }
//                 prev=arr[j][i];        
//             }
//         }
        
        
        
        
        
//         return res;
    }
}