class Solution {
    public boolean isMonotonic(int[] numbers) {
         if (numbers == null || numbers.length <= 2) return true;

        boolean isIncreasing = true, isDecreasing = true;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) isIncreasing = false;
            else if (numbers[i] < numbers[i + 1]) isDecreasing = false;
        }
        return isIncreasing || isDecreasing;
    }
}