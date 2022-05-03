class Solution {
    public int findUnsortedSubarray(int[] array) {
        
         // Write your code here.
   
        int len = array.length;

        
        if(len<=1)return 0;
        
        int maxUnsorted = Integer.MIN_VALUE, minUnsorted = Integer.MAX_VALUE;

    for (int i = 0; i < len; i++) {
      if (!isIndexUnsorted(i, array)) continue;

      minUnsorted = Math.min(minUnsorted, array[i]);
      maxUnsorted = Math.max(maxUnsorted, array[i]);
    }
        

    if (minUnsorted == Integer.MAX_VALUE) return 0;

    int firstIdx = 0;
    while (array[firstIdx] <= minUnsorted) ++firstIdx;

    int secondIdx = array.length - 1;
    while (array[secondIdx] >= maxUnsorted) --secondIdx;

    return secondIdx-firstIdx+1;
        //new int[] {firstIdx, };
    }
    
     private static boolean isIndexUnsorted(int index, int[] array) {
    if (index == 0) return array[index] > array[index + 1];

    if (index == array.length - 1) return array[index] < array[index - 1];

    return array[index] < array[index - 1] || array[index] > array[index + 1];
  }

}