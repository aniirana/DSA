class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
       

        

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i=0;i<n;i++){
            pq.offer(new int[]{speed[i],efficiency[i]});
        }

         PriorityQueue<Integer> speedPQ = new PriorityQueue<>();
        long sum=0;
        
        long ans=0;
        while(!pq.isEmpty()){
            int[] ele=pq.poll();
            sum+=ele[0];
            speedPQ.offer(ele[0]);
            

            if (speedPQ.size() > k)
                sum -= speedPQ.poll();

            ans=Math.max(ans,sum*ele[1]);
            
        }

       
      return (int)(ans % 1000000007);
    }
}