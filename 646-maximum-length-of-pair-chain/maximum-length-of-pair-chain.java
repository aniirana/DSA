class Solution {
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        Arrays.sort(pairs,(a,b)-> Integer.compare(a[1],b[1]));

        int start=pairs[0][1];
        int len=1;
        for(int i=1;i<n;i++){
            if(pairs[i][0]>start){
                len++;
                start=Math.max(start,pairs[i][1]);
            }
        }
        return len;
    }
}