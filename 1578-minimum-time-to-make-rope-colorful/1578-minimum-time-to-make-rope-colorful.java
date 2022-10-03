class Solution {
    public int minCost(String colors, int[] neededTime) {
          
        int cost = 0;

        for(int i = 0; i < neededTime.length-1;i++){
          
            
            if(i+1 < neededTime.length && colors.charAt(i) != colors.charAt(i+1)) continue; // skip this iteration when the color has not an equal neighbour
            
            int maxI = i, startI = i; // startIndex and maxIndex

            while(i+1 < neededTime.length && colors.charAt(i) == colors.charAt(i+1)){ // loop until another color appear 
                if(neededTime[maxI] < neededTime[i]) maxI = i; // find the index of the ballon with the highest time
                i++;
            }
            if(neededTime[maxI] < neededTime[i]) maxI = i; // also check the last ballon of same color

            for(; startI <= i; startI++) // use for loop to increase the val after every iteration
                if(startI != maxI) cost += neededTime[startI]; // if it's not the ballon with the highest time then add him to the time costs
        }

        return cost;
    }
}