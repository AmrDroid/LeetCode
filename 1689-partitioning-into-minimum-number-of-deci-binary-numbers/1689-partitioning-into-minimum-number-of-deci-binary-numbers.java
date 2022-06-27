class Solution {
    public int minPartitions(String n) {
         
        int max = n.charAt(0);
        
        int temp = 0;
        
        for(int i = 1;i<n.length();i++)
        {
            temp = n.charAt(i);
            if(max < temp)
                max = temp; 
        }
        return Character.getNumericValue(max);
    }
}