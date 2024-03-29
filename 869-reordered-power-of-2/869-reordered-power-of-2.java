class Solution {
    public boolean reorderedPowerOf2(int N) {
      int[] countN=count(N);
        
        int num=1;
        
        for(int i=0;i<31;i++){
            if(Arrays.equals(countN,count(num))){
                return true;
            }
            num=num<<1;
        }
        
        return false;
    }
    
    int[] count(int N){
        int[] arr = new int[10];
        while(N>0){
            arr[N%10]++;
            N/=10;
        }
        return arr;
    }
}