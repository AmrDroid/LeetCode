class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
     
         int result =0;
        int min= Integer.MIN_VALUE;
        
        //Here a[0] == b[0] means attacking powers are same , then we sort elements in decreasing
        //defensive power.Else we can sort in increasing attacking power.
        Arrays.sort(properties,(a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        for(int i=properties.length-1;i>=0;i--){// iterate backwards
            int[] arr = properties[i];
            int defense = arr[1];
            //when defense of current is < min , definitley a week character
            if(defense < min){
                result++;
            }
            //so that min stays at max defense
            min=Math.max(min,defense);
        }
        return result;
    }
}