class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        PriorityQueue<Vertex> queue=new PriorityQueue<>((x1,x2)->x1.height-x2.height);
        queue.add(new Vertex(0,0,grid[0][0]));
        while(true){
            Vertex temp=queue.poll();
            if(temp.i==n-1 && temp.j==m-1)
                return temp.height;
            else{
                addToQueue(temp,grid,queue);
            }
        }
        
    }
    void addToQueue(Vertex temp,int[][] grid,PriorityQueue<Vertex> queue){
        int i=temp.i,j=temp.j,n=grid.length,m=grid[0].length;
        //add up
        if(i-1>=0 && grid[i-1][j]!=-1){
            queue.add(new Vertex(i-1,j,Math.max(grid[i-1][j],temp.height)));
            grid[i-1][j]=-1;
        } 
        //add down
        if(i+1<n && grid[i+1][j]!=-1){
            queue.add(new Vertex(i+1,j,Math.max(grid[i+1][j],temp.height)));
            grid[i+1][j]=-1;
        } 
        //add left
        if(j-1>=0 && grid[i][j-1]!=-1){
            queue.add(new Vertex(i,j-1,Math.max(grid[i][j-1],temp.height)));
            grid[i][j-1]=-1;
        } 
        //add right
        if(j+1<m && grid[i][j+1]!=-1){
            queue.add(new Vertex(i,j+1,Math.max(grid[i][j+1],temp.height)));
            grid[i][j+1]=-1;
        }

    }
    class Vertex{
        int i;
        int j;
        int height;
        Vertex(int i,int j,int height){
            this.i=i;
            this.j=j;
            this.height=height;
        }
    }
}