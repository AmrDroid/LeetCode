class Solution {
   
      public int[] numsSameConsecDiff(int N, int K) {
         
            List<Integer> result = new ArrayList<Integer>();
            for (int num = 1; num < 10; ++num)
                dfs(N - 1, num, K, result);

            return result.stream().mapToInt(i -> i).toArray();
        }

        private void dfs(int N, int num, int K, List<Integer> result) {
            if (N == 0) {
                result.add(num);
                return;
            }

            if (num % 10 + K < 10)
                dfs(N - 1, num * 10 + num % 10 + K, K, result);

            if (K > 0 && num % 10 - K >= 0)
                dfs(N - 1, num * 10 + num % 10 - K, K, result);
        }
    
}