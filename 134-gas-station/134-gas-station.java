class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        if(n==1&&gas[0]<cost[0])return -1;
        if(n==1&&gas[0]>=cost[0])return 0;

        int start = 0;
        int end = 1;
        int curr_petrol = gas[start] - cost[start];

        while (end != start || curr_petrol < 0) {
            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while (curr_petrol < 0 && start != end) {// Remove starting petrol pump. Change start
                curr_petrol -= gas[start] - cost[start];
                start = (start + 1) % n;
                // If 0 is being considered as start again, then there is no
                // possible solution
                if (start == 0)
                    return -1;
            }
            // Add a petrol pump to current tour
            curr_petrol += gas[end] - cost[end];
            end = (end + 1) % n;
        }
        // Return starting point
        return start;
    }
}