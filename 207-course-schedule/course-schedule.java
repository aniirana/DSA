class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];

        for(int[] edge:prerequisites){
            int course=edge[0];
            int prereq=edge[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int count=0;

        while(!q.isEmpty()){
            int node=q.poll();
            
            count++;

            for(int neighbors: graph.get(node)){
                indegree[neighbors]--;
                if(indegree[neighbors]==0){
                    q.offer(neighbors);
                }
            }
        }

        return count==numCourses;
    }
}