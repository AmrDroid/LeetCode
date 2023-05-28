class Solution {

    private int util(int i, int j, int[] cuts, Map<ArrayList<Integer>, Integer> dp) {
        if (i>=j) return 0;
        ArrayList<Integer> index = new ArrayList<>();
      
        index.add(i); index.add(j);
        
        if (dp.containsKey(index)) return dp.get(index);
        
        int min = Integer.MAX_VALUE;
        
        for (int k=0; k<cuts.length; k++) {
            if (cuts[k]>=i && cuts[k]<j) {
                int value = util(i, cuts[k], cuts, dp);
                value += util(cuts[k]+1, j, cuts, dp);
                min = Math.min(min, value);
            }
        }
        dp.put(index, (min == Integer.MAX_VALUE ? 0 : min + (j-i+1)));
        return dp.get(index);
    }

    public int minCost(int n, int[] cuts) {
        Map<ArrayList<Integer>, Integer> dp = new HashMap<>();
        return util(1, n, cuts, dp);
    }
}