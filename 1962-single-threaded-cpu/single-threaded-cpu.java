class Solution {
    public int[] getOrder(int[][] tasks) {
        int m=tasks.length;
    
        int[][] arr=new int[m][3];

        for(int i=0;i<m;i++){
            arr[i][0]=tasks[i][0];
            arr[i][1]=tasks[i][1];
            arr[i][2]=i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });

        long time=0;
        int[] ans=new int[m];
        int i=0;
        int k=0;

        while(!pq.isEmpty() || i<m){
            if (pq.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            while(i<m && arr[i][0]<=time){
                pq.offer(arr[i]);
                i++;
            }

            int[] curr=pq.poll();
            ans[k++]=curr[2];
            time+=curr[1];
        }

        return ans;
        

    }
}