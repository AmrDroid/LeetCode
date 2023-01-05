class Solution {
    public boolean hasAlternatingBits(int n) {
         String a = Integer.toBinaryString(n);
        return !(a.contains("11") || a.contains("00"));
    }
}