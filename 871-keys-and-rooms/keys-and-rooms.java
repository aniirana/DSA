class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];

        dfs(0,vis,rooms);

        for(boolean room : vis){
            if(!room){
                return false;
            }
        }

        return true;

    }

    public void dfs(int i,boolean[] vis ,List<List<Integer>> rooms){
        vis[i]=true;

        for(int next : rooms.get(i)){
            if(!vis[next]){
                dfs(next,vis,rooms);
            }
        }
        
    }
}