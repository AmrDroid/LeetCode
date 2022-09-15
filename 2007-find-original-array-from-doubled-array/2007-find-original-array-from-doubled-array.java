class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if(changed.length %2 != 0) {
            return new int[0];
        }

        Arrays.sort(changed);

        // Count the no of occurance.
        Map<Integer, Integer> halfMap = new HashMap();
        for(int i = 0; i < changed.length ; i++) {
            halfMap.put(changed[i], halfMap.getOrDefault(changed[i], 0) + 1);
        }
        
        int res[] = new int[changed.length /2];
        int count = 0;
        
        for(int j = changed.length -1 ; j >= 0; j--) {
            // If it is not already considered as half 
            if(halfMap.get(changed[j]) > 0) {
                if(halfMap.getOrDefault(changed[j]/2, 0) > 0 && (changed[j] % 2 == 0)) {
                    res[count ++] = changed[j]/2; 
                    halfMap.put(changed[j]/2, halfMap.get(changed[j]/2) -1);
                } else {
                    return new int[0];
                }
                halfMap.put(changed[j], halfMap.get(changed[j]) -1);
            } 
        }

        return res;

    }
}