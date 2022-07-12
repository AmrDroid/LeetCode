class Solution {
  

    public boolean makesquare(int[] matchsticks) {
  int sum = 0 ;
    for(int i = 0 ; i < matchsticks.length ; i++){
        sum += matchsticks[i] ;
    }
    if(sum % 4 != 0){
        return false ;
    }
    Arrays.sort(matchsticks) ;
    return solve(matchsticks,sum/4,matchsticks.length-1,0,0,0,0) ;
}

public boolean solve(int[] matchsticks,int side,int idx,int top,int bottom,int left,int right){
    if(top == side && bottom == side && left == side && right == side && idx == -1){
        return true ;
    }
    if(top > side || bottom > side || left > side || right > side || matchsticks.length == -1){
        return false ;
    }
    int val = matchsticks[idx] ;
    boolean tp = solve(matchsticks,side,idx-1,top+val,bottom,left,right) ;
    if(tp) return true ;
    boolean btm = solve(matchsticks,side,idx-1,top,bottom+val,left,right) ;
    if(btm) return true ;
    boolean lft = solve(matchsticks,side,idx-1,top,bottom,left+val,right) ;
    if(lft) return true ;
    boolean ryt = solve(matchsticks,side,idx-1,top,bottom,left,right+val) ;
    if(ryt) return true ;
    
    return false ;
}
}