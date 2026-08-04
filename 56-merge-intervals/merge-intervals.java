class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b)->Integer.compare(a[0],b[0]));
        int n=intervals.length;

       
        
        List<int[]> ans=new ArrayList<>(); 
        int i=0;
        while(i<n){
            int currst=intervals[i][0];
            int currend=intervals[i][1];
            i++;

            while(i<n && currend>=intervals[i][0]){
                currend=Math.max(currend,intervals[i][1]);
                i++;
            }

            ans.add(new int[]{currst,currend});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}