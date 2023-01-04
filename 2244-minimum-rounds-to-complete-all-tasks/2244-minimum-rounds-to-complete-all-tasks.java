class Solution {
    public int minimumRounds(int[] tasks) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) 
            map.put(task, map.getOrDefault(task, 0) + 1);
     
        int count = 0;
        
        for (int val : map.values()) {
            if (val < 2) return -1;
            else if (val == 2) count++;
            else count += Math.ceil(val / 3.0);
        }
        return count;
    }
}