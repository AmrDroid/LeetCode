class Solution {
    public int longestMountain(int[] array) {
     
        int n = array.length;

        if(n < 3)		
            return 0;

        int maxL = 0;

        // iterate peak index from 1 to n - 2

        int peak = 1;

        while(peak < n - 1) {
		
            if(!(array[peak - 1] < array[peak] && array[peak] > array[peak + 1])) {			
                peak++;
			continue;
		}

        int left = peak - 2;
		int right = peak + 2;
		
        while(left >= 0 && array[left] < array[left + 1]) {
			left--;
		}
		
        while(right < n && array[right] < array[right - 1]) {
			right++;
		}
		
        maxL = Math.max(maxL, right - left - 1);
		
        peak = right;
	}
    
    
    return maxL;
        
        
    }
}