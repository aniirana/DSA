class Solution {
    class Pair{
        int row,col,dist;
        Pair(int r,int c,int d){
            this.row=r;
            this.col=c;
            this.dist=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] visited=new boolean[m][n];
        
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(0,0,1));

        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int rr=curr.row;
            int cc=curr.col;
            int dis=curr.dist;

            if (curr.row == n - 1 && curr.col == n - 1) {
                return curr.dist;
            }

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(i==0 && j==0){
                        continue;
                    }

                    int nr=rr+i;
                    int nc=cc+j;
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0 && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        queue.offer(new Pair(nr,nc,dis+1));
                    }

                }
            }
        }
        return -1;
    }
}