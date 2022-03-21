class Solution {
    public List<Integer> partitionLabels(String S) {
            
    List<Integer> res = new LinkedList<>();
    char[] arr = S.toCharArray();
    int n = arr.length;
    if(n == 0) return res;

    int[] t = new int[26];
    for(int i = 0; i < n; i++)
        t[arr[i] - 'a'] = i;
    
    //get the first char max index
    int max = t[arr[0] - 'a'];
    //the substring start index
    int s = 0;
    for(int i = 0; i < n;i++){
        
        if(i == max){
            
            //i == max is mean we got a require substring
            
            res.add(max - s + 1);
            
            s = max + 1;
            
            if(i + 1 < n)
                max = t[arr[i + 1] - 'a'];
            
        }else{ //find the max index of char in [s, max]
           
            max = Math.max(t[arr[i] - 'a'], max);
        }
    }
    return res;
        
    }
}