class Solution {
    public int leastInterval(char[] tasks, int n) {
         
        int result = 0;
		Map<Character, Integer> counts = new HashMap<>();
		
        for (char c  : tasks) {
			counts.put(c, counts.getOrDefault(c, 0)+1);
		}
		
		
        // use max heap to process max frequency element first;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
			maxHeap.add(entry.getValue()); // add frequency of each character
		}
		
        Queue<Integer> q = new LinkedList<>();
        
        
		while (!maxHeap.isEmpty()) {
		
            int time = 0;
			
            for (int i = 0; i < n+1; i++) {
                
				if (!maxHeap.isEmpty()) {
					q.add(maxHeap.peek()-1);
					maxHeap.remove();
					time++;
				}
			
            }
			
            while(!q.isEmpty()) {
				if (q.peek() > 0) {
					maxHeap.add(q.peek()); // push back in max heap					
				}
				q.remove();
			}
            
            result += maxHeap.isEmpty() ? time : n+1;
		}
		return result;
    }
}