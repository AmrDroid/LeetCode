class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
      int res = 0, n = people.length, 
        left = 0,
        right = n - 1;
        Arrays.sort(people);
            
        while (left <= right) {
        	if (people[left] + people[right] <= limit) 
                ++left;
            
            
        	--right;
        	++res;
        }
        return res;
    }
}

//1 2 2 3