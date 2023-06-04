class Solution {
    public int findCircleNum(int[][] isConnected) {

        List<List<Integer>> listAdj = new ArrayList<>();
        
        for (int i = 0; i < isConnected.length; i++) {
            int[] province = isConnected[i];
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < province.length; j++) if (province[j] == 1) list.add(j);
            listAdj.add(list);
        }
        
        boolean visited[] = new boolean[isConnected.length];
        int count = 0;
        
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, listAdj, visited);
            }
        }
        return count;
    }

    private void dfs(int i, List<List<Integer>> listAdj, boolean[] visited) {
        if (visited[i]) return;

        visited[i] = true;
        List<Integer> list = listAdj.get(i);
        for (int n : list) dfs(n, listAdj, visited);
    }
}