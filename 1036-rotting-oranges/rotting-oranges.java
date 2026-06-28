class Solution {
    class Pair{
        int row,col,time;
        Pair(int r,int c,int t){
            this.row=r;
            this.col=c;
            this.time=t;
            
        }
    }

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> queue=new LinkedList<>();
        int fresh=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int count=0;

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                Pair curr=queue.poll();

                int rr=curr.row;
                int cc=curr.col;
                
                for(int r=-1;r<=1;r++){
                    for(int c=-1;c<=1;c++){
                        if(Math.abs(r)!=Math.abs(c)){

                            int nrow=rr+r;
                            int ncol=cc+c;
                              if (nrow >= 0 && nrow < n &&
                                ncol >= 0 && ncol < m &&
                                grid[nrow][ncol] == 1) {

                                grid[nrow][ncol] = 2;
                                fresh--;
                                queue.offer(new Pair(nrow, ncol, curr.time + 1));
                            }
                        }
                    }
                }
                
                
                
                
              
            }
            if (!queue.isEmpty()) {
            count++;
        }
            
        }
        if (fresh > 0) {
    return -1;
}

return count;
        
    }
}