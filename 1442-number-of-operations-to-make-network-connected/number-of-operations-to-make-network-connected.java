class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
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
            return;
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
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds=new Disjoint(n);
        int m=connections.length;

        int cntextra=0;
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if(ds.findparent(u)==ds.findparent(v)){
                cntextra++;
            }
            else{
                ds.unionbysize(u,v);
            }
        }

        int cntc=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i){
                cntc++;
            }

        }

        int ans=cntc-1;

        if(cntextra>=ans) return ans;

        return -1;


        
    }
}