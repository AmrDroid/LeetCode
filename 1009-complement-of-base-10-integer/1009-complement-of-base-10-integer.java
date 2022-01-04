class Solution {
    public int bitwiseComplement(int num) {
        if(num==0)return 1;
           int res = ((Integer.highestOneBit(num)-1)<<1)+1;
        return res^num;
    }
}