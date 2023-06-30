class Solution {
    
    
   public int latestDayToCross(int row, int col, int[][] cells) {
        int [][]water=new int[row][col];

        for(int i=0;i<cells.length;i++){

            int r1=cells[i][0]-1;
            int c1=cells[i][1]-1;
             water[r1][c1]=i;
        }
       
       
        int low=0;
        int hi=cells.length-1;

        int ans=0;

        while(low<=hi){

        int mid=(low+hi)/2; 
          
        boolean isPossible=bfs(mid,water,row,col);

        if(isPossible){


            ans=mid;

            low=mid+1;
        }
        else{

            hi=mid-1;
        }


        }

        return ans+1;



           
    }

    public boolean bfs(int day,int [][]water,int rmax,int colmax){
        
        int[] ROWS = {-1, 1, 0, 0};
        
        int[] COLS = {0, 0, -1, 1};
        
        boolean [][]vis=new boolean[rmax][colmax];

        Queue<int[]> dq = new ArrayDeque<>();
        
        for(int i=0;i<colmax;i++){

             if(water[0][i]>day){
             dq.add(new int[]{0,i});
             }
             
         }

         while(dq.size()!=0){

             int size=dq.size();

             while(size-->0){
             
                int []rem=dq.remove();
            int row = rem[0];
            int col = rem[1];

            if(row==rmax-1){
                return true;
            }

            if(vis[row][col]==true){
                continue;
            }

            vis[row][col]=true;

            for(int i=0;i<ROWS.length;i++){

                int nx=row+ROWS[i];
                int ny=col+COLS[i];

                if(nx<rmax&&nx>=0&&ny>=0&&ny<colmax&&vis[nx][ny]==false&&water[nx][ny]>day){
                    dq.add(new int[]{nx,ny});
                }
             }
            }

         }
         return false;
    }

}