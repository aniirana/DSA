class Solution {
    class Tuple {
        int dist;
        int node;

        Tuple(int dist, int node) {
            this.dist = dist;
            this.node = node;
            }
        }
    class Pair{
        int node,time;
        Pair(int n,int t){
            this.node=n;
            this.time=t;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {

            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

            adj.get(u - 1).add(new Pair(v - 1, time));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k - 1] = 0;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);

        pq.offer(new Tuple(0,k-1));

        while(!pq.isEmpty()){
            Tuple curr=pq.poll();

            int dis=curr.dist;
            int node=curr.node;

            if(dis>dist[node]){
                continue;
            }

            for(Pair neigh: adj.get(node)){
                int adjnode=neigh.node;
                int adjdis=neigh.time;

                int newdis=adjdis+dis;

                if(newdis<dist[adjnode]){
                    dist[adjnode]=newdis;
                    pq.offer(new Tuple(newdis,adjnode));
                }
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;

            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}