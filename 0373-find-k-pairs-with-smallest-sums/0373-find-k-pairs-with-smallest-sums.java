class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
     
        
        List<List<Integer>> res = new ArrayList<>();
        
        int m = nums1.length, n = nums2.length;
        
        PriorityQueue<int[]> pairSums = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        
        pairSums.add(new int[]{nums1[0]+nums2[0], 0, 0});
        
        visited.add(new Pair<Integer, Integer>(0, 0));

        
        while(k-- > 0 && !pairSums.isEmpty()){

            int []currTuple = pairSums.poll();
            
            int i = currTuple[1], j = currTuple[2];
            
            List<Integer> temp = new ArrayList<>();
            
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            
            res.add(temp);

            // update the heap

            if(i+1 < m){
                Pair pair1 = new Pair<Integer, Integer>(i+1, j);
                if(!visited.contains(pair1)){
                    pairSums.add(new int[]{nums1[i+1]+nums2[j], i+1, j});
                    visited.add(pair1);
                }
            }
            if(j+1 < n){
                Pair pair2 = new Pair<Integer, Integer>(i, j+1);
                if(!visited.contains(pair2)){
                    pairSums.add(new int[]{nums1[i]+nums2[j+1], i, j+1});
                    visited.add(pair2);
                }
            }
        }
        return res;
        
        
        
    }
}