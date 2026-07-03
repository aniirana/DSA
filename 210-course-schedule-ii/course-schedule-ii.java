class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        Queue<Integer> queue=new LinkedList<>();
           
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int[] ans=new int[numCourses];
        int idx=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans[idx++]=node;
            for(int neighbor:graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                }
                
            }
        }

        if(idx != numCourses){
            return new int[0];
        }

        return ans;
        
    }
}