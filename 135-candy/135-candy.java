class Solution {
    public int candy(int[] scores) {
        // Write your code here.
    
        
    int len = scores.length;
    int[] rewards = new int[len];
    Arrays.fill(rewards, 1);

    for (int i = 1; i < len; i++) {
      if (scores[i] > scores[i - 1]) rewards[i] += rewards[i - 1];
    }

        
    for (int i = len - 2; i >= 0; i--) {
      if (scores[i] > scores[i + 1]) rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
    }
        

    int minRewards = 0;
    for (int reward : rewards) minRewards += reward;

    return minRewards;
    }
}