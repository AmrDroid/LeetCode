class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> word_count=new HashMap();
        for(String str:words)
        {
            word_count.put(str,word_count.getOrDefault(str,0)+1);            
        }
        
             PriorityQueue<String> pq = new PriorityQueue<>(
            (w1, w2) -> word_count.get(w1).equals(word_count.get(w2)) ? w2.compareTo(w1) 
                 : word_count.get(w1) - word_count.get(w2));
        
        for (String word : word_count.keySet()) {
            pq.offer(word);            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> ans = new ArrayList();
        
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        
        Collections.reverse(ans);
        return ans;
    }
}