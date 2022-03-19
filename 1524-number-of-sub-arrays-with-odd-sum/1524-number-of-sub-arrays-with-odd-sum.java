class Solution {
    public int numOfSubarrays(int[] arr) {
          
    int mod = 1000000007;
    //prefix sum
    int sum = 0;
    //count the prefix sum is even and odd
        int even = 1, odd = 0;
        int res = 0;

        for(int i : arr){
        
            sum += i;

            if((sum & 1) != 0){
            //if sum is odd, so the odd sub array count is even,  because even + odd = odd,
            //if [0, j] subarray is even, so (j, i] is odd
                res = (res + even) % mod;
                odd++;
        
            }else{
                res = (res + odd) % mod;
                even++;
            }
            
        }    
        
        return res;
    }
}