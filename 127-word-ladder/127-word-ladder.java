class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         if (beginWord == endWord)
            return 0;
        
        if (!wordList.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();

        Queue<String> newQueue = new LinkedList<>();
        
        Set<String> used = new HashSet<String>();
        
        Set<String> wordSet = new HashSet<String>(wordList);
        
        int distance = 1;
        
        queue.add(beginWord);
        
        while(!queue.isEmpty()) {
        
            String head = queue.poll();
            for (int i=0; i<head.length(); i++) {
                
                StringBuilder builder = new StringBuilder(head);
                
                for (int j=0; j<26; j++) {
                
                    if ('a'+j != head.charAt(i)) {
                    
                        builder.setCharAt(i, (char)('a'+j));
                        
                        String newWord = builder.toString();
                        
                        if (wordSet.contains(newWord) && !used.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return distance+1;
                            }
                            newQueue.offer(newWord);
                            used.add(newWord);
                        }
                    }
                }
            }
            if (queue.isEmpty()) {
                queue = newQueue;
                newQueue = new LinkedList<>();
                distance ++;
            }
        }
        return 0;
    }
}