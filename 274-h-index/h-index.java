class Solution {
    public int hIndex(int[] citations) {
        int ans=0;
        int n=citations.length;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=n-i){
                ans=n-i;
                break;
            }
        }
        return ans;
    }
}