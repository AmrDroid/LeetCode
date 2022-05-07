class Solution {
    public boolean find132pattern(int[] nums) {
       
        
        int n = nums.length;
        
        Stack<Pair> s=new Stack();
        int curMin=nums[0];
        
        
        for(int num:nums)
        {
            while(!s.isEmpty()&&  num>=s.peek().num)
                s.pop();
            
            if(!s.isEmpty() && num > s.peek().min)
                return true;
            
            s.push(new Pair(curMin,num));
            curMin= Math.min(curMin,num);
        }
        
        return false;
        
    }
    
    
    
    class Pair{
        int min;
        int num;
        
        Pair(int m,int n)
        {
            this.min=m;
            this.num=n;
        }
    }
    
}

