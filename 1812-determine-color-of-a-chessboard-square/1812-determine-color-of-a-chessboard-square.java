class Solution {
    public boolean squareIsWhite(String coordinates) {
     
        
        int n = (coordinates.charAt(0)-96) + (coordinates.charAt(1)-48);
        if(n%2!=0)
            return true;
        else
            return false;
    }
}