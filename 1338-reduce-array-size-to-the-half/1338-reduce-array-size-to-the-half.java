class Solution {
    public int minSetSize(int[] arr) {
       
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1])); //priorityQueue base don frequency
        
        int cnt[] = new int[100001];
        for(int i:arr){
            cnt[i]++;  //count each occurance
        }
        
        
        for(int i=1;i<=100000;i++){
            if(cnt[i]>0){
                pq.offer(new int[]{i,cnt[i]});
            }
        }
        
        
        int res=0,n=arr.length,ans=0;
        
        while(res<(n+1)/2){
            res+=pq.poll()[1];
            ans++;
        }
        
        return ans;
    }
}