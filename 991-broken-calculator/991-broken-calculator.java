class Solution {
    public int brokenCalc(int X, int Y) {
         int count = 0;
        while (Y > X){
            count++;
            if (Y % 2 == 1){
                Y++;
            }else{
                Y /= 2;
            }
        }
        return count + X - Y;
    
        
        /*  if (X >= Y){
            return X - Y;
        }
        if (Y % 2 == 1){
            return brokenCalc(X, Y + 1) + 1;
        }
        return brokenCalc(X, Y/2) + 1;
    
    */
    }
}