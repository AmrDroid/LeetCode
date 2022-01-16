class Solution {
    public int subarraySum(int[] arr, int k) {
       int n =arr.length;
        
        Map<Integer,Integer> m =new HashMap();
        
        
        int currSum=0;
        int c=0;
        
        for(int i=0;i<n;i++)
        {
            currSum+=arr[i];
            
            if(currSum==k)
                c++;
            
            if(m.containsKey(currSum-k))
                c+=m.get(currSum-k);
            
            m.put(currSum,m.getOrDefault(currSum,0)+1);
            
        }
        
        return c;       
    }
}