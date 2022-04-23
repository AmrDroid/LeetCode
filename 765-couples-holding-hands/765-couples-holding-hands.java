class Solution {
    
    Map<Integer,Integer> m=new HashMap();
    public int minSwapsCouples(int[] row) {
        
        int n =row.length;
        
        for(int i=0;i<n;i++)
            m.put(row[i],i);
        
        int swaps=0;
        for(int i=0;i<n;i+=2)
        {
            
            int first = row[i];
            int second = first ^ 1;
            
            if(row[i+1]!=second)
            {
                swaps++;
                swap(row,i+1, m.get(second));
                
            }
            
        }
        
        return swaps;
    }
    
    void swap(int row[],int i , int j)
    {
        int t=row[i];
        row[i]=row[j];
        row[j]=t;
        
        m.put(row[i],i);
        m.put(row[j],j);
        
        
    }
}