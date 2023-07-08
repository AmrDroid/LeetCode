class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n=weights.length;
        long max=0,min=0;
        
        int [] conAdd=new int[n-1];
        
        for(int i=0;i<n-1;i++) 
            conAdd[i]=weights[i]+weights[i+1];
        
        Arrays.sort(conAdd);
        
        int l=0,r=n-2;
        
        k--;
        
        
        while(k-->0){
            max+=conAdd[r--];
            min+=conAdd[l++];
        }
        return max-min;
    }
}