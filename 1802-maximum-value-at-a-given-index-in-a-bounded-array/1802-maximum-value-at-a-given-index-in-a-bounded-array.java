class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
           
 
        int s = 1 , e = maxSum ; 
        
        int ans = -1; 

        while(s<=e){
            
            int mid = (s+e)/2 ;

            long k = mid ;          // to avoid overflow
            
            long sum = k ; 

            long left_sum = (index-k+1) +  (k*(k-1))/2 ; 
            
            if(k-1> index){         // not enough cols on left of index
                int left_cols = index ; 
                left_sum = ((k-1)*k)/2 - ((k-left_cols-1)*(k-left_cols))/2; 
            }


            long right_sum = (k*(k-1))/2 + (n- index- k) ; 
            if(n-index-k<0){            // not enough cols on right of index
                int right_cols = n- (index+1) ; 
                right_sum = (k*(k-1))/2 - ((k-right_cols-1)*(k-right_cols))/2 ; 
            }

            sum += (left_sum + right_sum) ; 
            if(sum<= maxSum){
                s = mid+1 ; 
                ans = mid ; 
            }
            else e = mid-1 ; 
        }
    return ans ;   
        
    }
}