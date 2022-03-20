class Solution {
List<List<Integer>> res=new ArrayList();
            public List<List<Integer>> combine(int n, int k) {
        
        backTrack(n,k,1,new ArrayList<Integer>());
        
        return res;
    }
    
    void backTrack(int n ,int k,int ind , List<Integer> l)
    {
        
        if(l.size()==k)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=ind;i<=n;i++)
        {
            l.add(i);
            backTrack(n,k,i+1,l);
            l.remove(l.size()-1);
        }
        
        
    }
}