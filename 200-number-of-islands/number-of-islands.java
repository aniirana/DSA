class Solution {
    class Pair{
        int row,col;
        Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public int numIslands(char[][] grid) {
        int v=grid.length;
        int w=grid[0].length;
        boolean[][] visited=new boolean[v][w];
        int count=0;
        Queue<Pair> queue=new LinkedList<>();
        
        for(int i=0;i<v;i++){
            for(int j=0;j<w;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    visited[i][j]=true;
                    queue.offer(new Pair(i,j));

                    while(!queue.isEmpty()){
                        Pair cur=queue.poll();

                        for(int k=0;k<v;k++){

                            for(int m=-1;m<=1;m++){
                                for(int n=-1;n<=1;n++){
                                    if(Math.abs(m)!=Math.abs(n)){
                                        int nr=cur.row+m;
                                        int nc=cur.col+n;


                                        if(nr>=0 && nr<v && nc>=0 && nc<w && grid[nr][nc]=='1' && !visited[nr][nc]){
                                            visited[nr][nc]=true;
                                            queue.offer(new Pair(nr,nc));
                                        }
                                        
                                        
                                        
                                    }
                                }
                            }



                            
                        }
                    }
                }
            }
        }
        

        return count;
   }
}


