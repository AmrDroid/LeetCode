class Solution {
    public int numPairsDivisibleBy60(int[] time) {
     
        int[] remainder = new int[60];
        
        int count = 0;
        
        for (int item: time) {
            remainder[(item + 60) % 60]++;
        }

        count += (remainder[0] * remainder[0] - remainder[0]) / 2;
        
        count += (remainder[30] * remainder[30] - remainder[30]) / 2;

        for (int i = 1; i <= 29; i++) {
            count += remainder[i] * remainder[60-i];
        }
        return count;
    }
}