class Solution {
    public int findShortestSubArray(int[] nums) {
       
        HashMap<Integer, ArrayList<Integer>> counter = new HashMap<>();
        
        for (int i = 0 ; i < nums.length ; i++) {
            counter.putIfAbsent(nums[i], new ArrayList<>());
            counter.get(nums[i]).add(i);
        }

        int maxFreq = -1;
        
        ArrayList<Integer> keys = new ArrayList<>();
        
        for (Integer key : counter.keySet()) {
            if (counter.get(key).size() > maxFreq) {
                maxFreq = counter.get(key).size();
                keys = new ArrayList<>();
                keys.add(key);
            } else if (counter.get(key).size() == maxFreq) {
                keys.add(key);
            }
        }

        ArrayList<Integer> indices;
        int result = 50001, diff;
        for (int key : keys) {
            indices = counter.get(key);
            diff = indices.get(indices.size() - 1) - indices.get(0) + 1;
            if (diff < result) {
                result = diff;
            }
        }

        return result; 
    }
}