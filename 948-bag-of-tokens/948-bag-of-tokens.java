class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, maxScore = 0;
        Arrays.sort(tokens);
        int n = tokens.length;
        int l=0, r=n-1;
       
        while(l <= r) {
            if(tokens[l] <= power) {               // Case 1- When power[i] is at least token & he can face-up 
                score++;
                power -= tokens[l++];
            }
            else if(score >= 1) {                   // Case 2- When score is at least one & you can play by face-down
                power += tokens[r--];
                score--;
            }
            else                                           // Else we cannot play 
                break;
            
            maxScore = Math.max(score, maxScore);        //  Having maximum score till ith token 
        }
        return maxScore;
    }
}