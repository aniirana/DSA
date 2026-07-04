class Solution {
    class Pair{
        int node,cost;
        Pair(int n,int c){
            this.node=n;
            this.cost=c;
        }
    }
    class Tuple{
        int stops,node,cost;
        Tuple(int stops,int node,int cost){
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] flight:flights){
            adj.get(flight[0]).add(new Pair(flight[1],flight[2]));

        }

        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);

        dis[src] = 0;
        
        Queue<Tuple> queue=new LinkedList<>();
        queue.offer(new Tuple(0,src,0));

        while(!queue.isEmpty()){
            Tuple curr=queue.poll();
            int stop=curr.stops;
            int node=curr.node;
            int cost=curr.cost;

            if(stop>k){
                continue;
            }

            for(Pair neighbor:adj.get(node)){
                int newcost=cost+neighbor.cost;

                if(newcost<dis[neighbor.node]){
                    dis[neighbor.node]=newcost;

                    queue.offer(new Tuple(stop+1,neighbor.node,newcost));
                }
            }
        }
        return dis[dst]==Integer.MAX_VALUE ? -1 : dis[dst];
    }
}