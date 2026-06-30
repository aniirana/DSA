class Solution {
    class Pair{
        int row,col;
        Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int[][] dis=new int[m][n];
        Queue<Pair> queue=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dis[i][j]=0;
                    queue.offer(new Pair(i,j));
                }
                if(mat[i][j]==1){
                    dis[i][j]=-1;
                }
            }
        }

        while(!queue.isEmpty()){
            int size=queue.size();
            int r=queue.peek().row;
            int c=queue.peek().col;
            queue.poll();

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        int nr=r+i;
                        int nc=c+j;

                        if(nr>=0 && nr<m && nc>=0 && nc<n && dis[nr][nc]==-1 ){
                            dis[nr][nc]=dis[r][c]+1;
                            queue.offer(new Pair(nr,nc));
                        }
                    }
                }
            }

        }
        return dis;
    }
}