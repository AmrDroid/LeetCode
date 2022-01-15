class Solution {
    public int minJumps(int[] arr) {
       Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
                valueToIndices.computeIfAbsent(arr[i], k -> new LinkedList<>()).add(i);
            }
        
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> indexQueue = new LinkedList<>();
        indexQueue.offer(0);
        int steps = 0;
        
            while (!indexQueue.isEmpty()) {
        
                int size = indexQueue.size();
                
                for (int i = 0; i < size; i++) {
                
                    int index = indexQueue.poll();
                    
                    if (index == arr.length - 1) {
                        return steps;
                    }
                    
                    List<Integer> nextPossibleIndices = valueToIndices.get(arr[index]);
                    
                    nextPossibleIndices.add(index - 1);
                    
                    nextPossibleIndices.add(index + 1);
                    
                    for (int next : nextPossibleIndices) {
                        if (next >= 0 && next < arr.length && !visited[next]) {
                            visited[next] = true;
                            indexQueue.offer(next);
                        }
                    }
                    nextPossibleIndices.clear();
                }
                steps++;
            }
            return 0;
    }
}