/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {

    
    
    private int match(String guess, String w) {
        int match = 0;
        for (int i = 0; i < w.length(); i++) {
            if (guess.charAt(i) == w.charAt(i)) match++;
        }
        return match;
    }
    
    public void findSecretWord(String[] wordlist, Master master) {
    
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
        
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            
            x = master.guess(guess);
            
            List<String> wordlist2 = new ArrayList<>();
            
            for (String w : wordlist) {
                
                if (match(w, guess) == x) {
                    wordlist2.add(w);
                }
            
            }
            
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
    


}