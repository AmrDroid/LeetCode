class Solution {
    public boolean mergeTriplets(int[][] T, int[] target) {
        
        
        return check(T, target, 0) && check(T, target, 1) && check(T, target, 2);
    
    }

    private boolean check(int[][] tri, int[] target, int j){
   
        for (int[] t : tri){
        
            if (t[j] == target[j] 
                
                && t[(j + 1) % 3] <= target[(j + 1) % 3] 
                
                && t[(j + 2) % 3] <= target[(j + 2) % 3])
                
                
                return true;
        }
        
        return false;
    }
        
}