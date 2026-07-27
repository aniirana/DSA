class Disjoint{
    int[] parent;
    int[] size;
    Disjoint(int n){
        parent=new int[n];
        size=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int findparent(int node){
        if(node==parent[node]){
            return node;
        }

        return parent[node]=findparent(parent[node]);
    }

    public void unionbysize(int u,int v){
        int pu=findparent(u);
        int pv=findparent(v);

        if(pu==pv){
            return ;
        }

        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }
}




class Solution {
    public int largestIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Disjoint ds=new Disjoint(m*n);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;

                for(int a=-1;a<=1;a++){
                    for(int b=-1;b<=1;b++){
                        if(Math.abs(a)!=Math.abs(b)){
                            int nr=i+a;
                            int nc=j+b;

                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                                int rowno=i*n+j;
                                int nrowno=nr*n+nc;

                                ds.unionbysize(rowno,nrowno);
                            }
                        }
                    }
                }
            }
        }

        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> components=new HashSet<>();
                for(int a=-1;a<=1;a++){
                    for(int b=-1;b<=1;b++){
                        if(Math.abs(a)!=Math.abs(b)){
                            int nr=i+a;
                            int nc=j+b;

                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                                components.add( ds.findparent(nr*n+nc));
                            }
                        }
                    }
                }

                int size=0;
                for(Integer parent:components){
                    size+=ds.size[parent];
                }
                max=Math.max(max,size+1);
                

                
            }
        }

        for(int c=0;c<n*n;c++){
            max=Math.max(max,ds.size[ds.findparent(c)]);
        }

        return max;
    }
}