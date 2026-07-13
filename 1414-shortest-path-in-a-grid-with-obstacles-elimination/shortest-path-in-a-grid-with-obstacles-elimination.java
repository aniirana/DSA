class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        int rem;
        Pair(int r,int c,int d,int rem){
            this.row=r;
            this.col=c;
            this.dist=d;
            this.rem=rem;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][][] vis=new boolean[m][n][k+1];
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(0,0,0,k));
        
        vis[0][0][k] = true;
        while(!queue.isEmpty()){
            Pair node=queue.poll();
            int rr=node.row;
            int cc=node.col;
            int dis=node.dist;
            int rem=node.rem;

            if(rr==m-1 && cc==n-1){
                return dis;
            }

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        int nr=rr+i;
                        int nc=cc+j;

                        if(nr<0 || nr>=m || nc<0 || nc>=n ){
                            continue;
                        }

                        if(grid[nr][nc]==0 && !vis[nr][nc][rem]){
                            vis[nr][nc][rem] = true;
                            queue.offer(new Pair(nr,nc,dis+1,rem));
                        }

                        if(grid[nr][nc]==1 && rem>0 && !vis[nr][nc][rem-1]){
                            vis[nr][nc][rem - 1] = true;
                            queue.offer(new Pair(nr,nc,dis+1,rem-1));
                        }
                    }
                }
            }

        }
        return -1;
    }
}