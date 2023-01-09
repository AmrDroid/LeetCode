class Solution {
    public int[] findPeakGrid(int[][] mat) {
         
        int start=0,end=mat.length-1;
        
        while(start<=end)
        {
        
            int mid=(start+end)/2;
            
         //   System.out.println(mid);
            int mp=maxPos(mat,mid);
            
            if(mid==0 && mat[mid][mp]>mat[mid+1][mp]) return new int[]{mid,mp};
            
            else if(mid==mat.length-1 && mat[mid][mp]>mat[mid-1][mp]) return new int[]{mid,mp};
            
            else if(mat[mid][mp]>mat[mid+1][mp] && mat[mid][mp]>mat[mid-1][mp]) return new int[]{mid,mp};
            
            if(mat[mid][mp]<mat[mid+1][mp]) start=mid+1;
            
            else end=mid-1;
            
        }
        return new int[]{-1,-1};
    }
    private int maxPos(int[][] arr,int mid)
    {
        int mp=0,sum=arr[mid][0];
        for(int i=1;i<arr[mid].length;i++)
           if(sum<arr[mid][i])
            {
                sum=arr[mid][i];
                mp=i;
            }
        return mp;
    }
}