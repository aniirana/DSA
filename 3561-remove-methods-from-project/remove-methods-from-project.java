class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[n];
        indegree[k]=1;
        for(int[] edge:invocations){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            
        }

        boolean[] vis=new boolean[n];
        
        dfs(k,adj,vis);
        boolean flag=true;
        

        for(int[] edge:invocations){
            int u=edge[0];
            int v=edge[1];

            if(!vis[u] && vis[v]){
                List<Integer> list=new ArrayList<>();

                for(int i=0;i<n;i++){
                    list.add(i);
                }
                return list;
            }
            
        }

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
               list.add(i);
            }
        }

        return list;

    }

    public void dfs(int i, ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[i]=true;

        for(int neigh:adj.get(i)){
            if(!vis[neigh]){
                dfs(neigh,adj,vis);
            }
        }
    }
}