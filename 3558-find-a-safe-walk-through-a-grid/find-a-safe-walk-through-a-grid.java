class Solution {
    class Pair{
        int row,col,weight;
        Pair(int r,int c,int w){
                this.row=r;
                this.col=c;
                this.weight=w;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        Deque<Pair> dq=new LinkedList<>();

        int[][] dis=new int[m][n];

        for (int[] row : dis)
            Arrays.fill(row, Integer.MAX_VALUE);

        dis[0][0]=grid.get(0).get(0);

        dq.offerFirst(new Pair(0,0,0));

        while(!dq.isEmpty()){
            Pair curr=dq.pollFirst();
            int rr=curr.row;
            int cc=curr.col;
            int d=curr.weight;

            if (d > dis[rr][cc])
                continue;

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        int nr=rr+i;
                        int nc=cc+j;

                        if(nr>=0 && nr<m && nc>=0 && nc<n){
                            int weight=grid.get(nr).get(nc);
                            if(dis[rr][cc]+weight<dis[nr][nc]){
                                dis[nr][nc]=dis[rr][cc]+weight;


                                if(weight==0){
                                    dq.offerFirst(new Pair(nr,nc,weight));
                                }
                                if(weight==1){
                                    dq.offerLast(new Pair(nr,nc,weight));
                                }
                            }

                            
                        }
                    }
                }
            }
            
        }

        return health-dis[m-1][n-1]>=1;
        
    }
}