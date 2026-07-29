class Solution {
    class Pair{
        int row,col,dis;
        Pair(int r,int c,int d){
            this.row=r;
            this.col=c;
            this.dis=d;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        boolean[][] vis=new boolean[m][n];

        
        Queue<Pair> q=new LinkedList<>();
        int min=Integer.MAX_VALUE;

        q.offer(new Pair(entrance[0],entrance[1],0));
        vis[entrance[0]][entrance[1]]=true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int rr=curr.row;
            int cc=curr.col;
            int dis=curr.dis;

            if(maze[rr][cc]=='.'){
                if(rr!=entrance[0] || cc!=entrance[1]){
                    if(rr==0 || cc==0 || rr==m-1 || cc==n-1){
                        min=Math.min(min,dis);
                    }
                }
            }
            



            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        
                        int nr=rr+i;
                        int nc=cc+j;
                        
                        if(nr>=0 && nr<m && nc>=0 && nc<n && maze[nr][nc]!='+' && !vis[nr][nc]){
                            vis[nr][nc]=true;
                            q.offer(new Pair(nr,nc,dis+1));
                        }
                    }
                }
            }
        }

        return min==Integer.MAX_VALUE?-1:min;
    }
}