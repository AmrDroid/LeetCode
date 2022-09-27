class Solution {
    public String pushDominoes(String dominoes) {
        
        int left = -1, right = -1;
       
        char[] chars = dominoes.toCharArray();

        for (int idx = 0; idx <= chars.length; idx++) {
        
            if (idx == chars.length || chars[idx] == 'R') {

                if (right > left)
                    while (right < idx) chars[right++] = 'R';
                else right = idx;

            } else if (chars[idx] == 'L') {

                if (right > left){
                    left = idx;
                    while (right < left) {
                        chars[right++] = 'R'; chars[left--] = 'L';
                    }
                }else
                    while (++left <= idx) chars[left] = 'L';
                left = idx;
            }
        }
        return String.valueOf(chars);
    }
    
    
}