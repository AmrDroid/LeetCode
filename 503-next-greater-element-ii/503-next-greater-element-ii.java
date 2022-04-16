class Solution {
    public int[] nextGreaterElements(int[] nums) {
    
        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-2;i>=0;i--){
            st.push(nums[i]);
        }
        
        for(int i=nums.length-1;i>=0;i--){
        
            while(!st.isEmpty() && st.peek()<=nums[i])
                st.pop();
            
            int temp=nums[i];
            if(st.isEmpty())
                nums[i]=-1;
            else
                nums[i]=st.peek();
            st.push(temp);
        }
        return nums;
    }
}