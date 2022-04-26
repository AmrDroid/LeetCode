class Solution {
    int V;
    int minKey(int key[], Boolean mstSet[]) {// Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }
    
    
    public int minCostConnectPoints(int[][] points) {

        V = points.length;
        int graph[][]=new int[V][V];

        for(int i=0;i<V;i++)
        {  
            int x1 = points[i][0],y1=points[i][1];            
            for(int j=i+1;j<V;j++)
            {
                int x2= points[j][0],y2=points[j][1];
                int dist= Math.abs(x1-x2)+ Math.abs(y1-y2);
                graph[i][j]=dist;
                graph[j][i]=dist;                
            }            
        }
        
        
        
        int parent[] = new int[V+1];     
        int key[] = new int[V+1];
        Boolean mstSet[] = new Boolean[V]; 

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0; 
        parent[0] = -1;
    
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
            
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        
        int res=0;        
         for (int i = 1; i < V; i++)
           res+= graph[i][parent[i]];
        
        return res;
        
    }
}