class Solution {
    public List<List<Integer>> generate(int numRows) {
     
        List<List<Integer>> res=new ArrayList();
        if(numRows==0)return res;
    
        List<Integer> list=new ArrayList();
        list.add(1);
        res.add(list);
        
        if(numRows==1)return res;
        
        List<Integer> list2=new ArrayList();
        list2.add(1);
        list2.add(1);
        
        res.add(list2);
        
            List<Integer> prev=list2;
        for(int i=2;i<numRows;i++)
        {
            List<Integer> l=new ArrayList();
            
            l.add(1);            
            for(int j=0;j<prev.size()-1;j++)
                l.add(prev.get(j)+prev.get(j+1));    
            
            l.add(1);
            res.add(l); 
            prev=l;
        }
        return res;
        
        
    }
}