class Solution {
    class Node{
        int row,col,state;
        Node(int ro,int co,int st){
            this.row=ro;
            this.col=co;
            this.state=st;
        }
    }
    class Pair{
        int row,col;
        Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m=grid.size();
        int n=grid.get(0).size();
        Queue<Pair> queue=new LinkedList<>();

        int[][] dist=new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    queue.offer(new Pair(i,j));
                    dist[i][j]=0;
                }
            }
        }  

        while(!queue.isEmpty()){
            Pair curr=queue.poll();
            int rr=curr.row;
            int cc=curr.col;

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        int nr=rr+i;
                        int nc=cc+j;

                        if(nr>=0 && nr<m && nc>=0 && nc<n && dist[nr][nc]==-1){
                            dist[nr][nc]=1+dist[rr][cc];
                            queue.offer(new Pair(nr,nc));
                        }

                    }
                }
            }
        } 

        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->b.state-a.state);

        int[][] best=new int[m][n];
        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        pq.offer(new Node(0,0,dist[0][0]));
        best[0][0]=dist[0][0];

        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int r=cur.row;
            int c=cur.col;
            int st=cur.state;

            if(r == m-1 && c == n-1){
                return st;
            }

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        int nrr=r+i;
                        int ncc=c+j;

                        if(nrr>=0 && nrr<m && ncc>=0 && ncc<n ){
                            int newstate=Math.min(st,dist[nrr][ncc]);
                        

                            if(newstate>best[nrr][ncc]){
                                best[nrr][ncc]=newstate;
                                pq.offer(new Node(nrr,ncc,newstate));
                            
                            }
                        }
                    }
                }
            }
        }
        return -1;

    }
}