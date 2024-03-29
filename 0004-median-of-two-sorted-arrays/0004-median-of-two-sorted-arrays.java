class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
   
  int m = nums1.length, n = nums2.length;
      
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0, end = m, mid = m + n + 1 >> 1;
        while (start <= end) {
            int i = start + (end - start >> 1);
            int j = mid - i;
            if (i < end && nums1[i] < nums2[j - 1]) {
                start = i + 1;
            } else if (i > start && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n & 1) == 1) {
                    return maxLeft;
                }
                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
        
    }
}