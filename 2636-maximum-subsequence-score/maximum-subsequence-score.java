class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;

        int[][] pairs= new int[n][2];

        for(int i=0;i<n;i++){
            pairs[i][0]=nums2[i];
            pairs[i][1]=nums1[i];

        }

        Arrays.sort(pairs,(a,b) ->b[0]-a[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        long sum=0;
        long maxsum=0;

        for(int[] pair:pairs){
            pq.offer(pair[1]);
            sum+=pair[1];
            int min = pair[0];

            while(pq.size() >k){
                sum -=pq.poll();
            }

            if(pq.size()==k){
                maxsum=Math.max(maxsum,sum*min);
            }
        }

    return maxsum;

    }
}