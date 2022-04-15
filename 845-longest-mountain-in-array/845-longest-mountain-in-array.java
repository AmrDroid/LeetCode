class Solution {
    public int longestMountain(int[] arr) {
     
       int n= arr.length;
        
        
        int res=0;
        
        
        for(int i=1;i<n;i++)
        {
           //increasing
            int count =1;
            int j=i;
            boolean flag=false;
            
            while(j<n&&arr[j]>arr[j-1])
            {
                count++;
                j++;
            }
            
            //decreasing
            
            while( i!=j && j<n&&arr[j]<arr[j-1])
            {
                count++;
                j++;
                flag=true;
            }
            
            
            if(flag && count>2 && i!=j)
            {
                res=Math.max(res,count);                
                j--;
            }
            
            i=j;
            
            
        }
        
        
        
        return res;
        
        
    }
}