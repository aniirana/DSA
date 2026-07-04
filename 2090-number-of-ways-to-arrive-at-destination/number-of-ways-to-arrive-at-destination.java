class Solution {
    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    class Tuple {
        long dist;
        int node;

        Tuple(long dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time)); 
        }

        PriorityQueue<Tuple> pq=new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        
        long[] dis=new long[n];
        int[] ways=new int[n];

        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0]=0;
        ways[0]=1;

        pq.offer(new Tuple(0,0));

        int MOD = 1_000_000_007;

        while(!pq.isEmpty()){
            Tuple curr=pq.poll();

            long dist=curr.dist;
            int node=curr.node;
            
             if (dist > dis[node])
            continue;

            for(Pair neighbor:adj.get(node)){
                long newdis=dist+neighbor.time;

                if(newdis<dis[neighbor.node]){
                    dis[neighbor.node]=newdis;
                    ways[neighbor.node]=ways[node];

                    pq.offer(new Tuple(newdis,neighbor.node));
                }

                else if (newdis == dis[neighbor.node]) {

                    ways[neighbor.node] = (ways[neighbor.node] + ways[node]) % MOD;
                }   

            }
        }
        return ways[n-1];
    }
}