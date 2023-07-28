class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int res=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[i-1])
                res++;
        } 
        
        return res;
        
        
        /*
        
           int lo = 0, hi = A.length - 1;
     
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            System.out.println(lo+"  "+hi+"  "+mi);
            if (A[mi] < A[mi + 1]) {
                lo = mi + 1;
            } else {
                hi = mi;   
            }
        }
        return lo;
        */
    }
}