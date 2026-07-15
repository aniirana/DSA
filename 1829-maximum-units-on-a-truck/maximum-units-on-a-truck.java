class Solution {
    public int maximumUnits(int[][] boxTypes, int capacity) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int profit=0;
        for(int i=0;i<n;i++){
            if(capacity==0){
                return profit;
            }
            else if(boxTypes[i][0]>capacity){
                
                profit=profit+(capacity*boxTypes[i][1]);
                capacity=0;
            }else{
                capacity=capacity-boxTypes[i][0];
                profit=profit+(boxTypes[i][0]*boxTypes[i][1]);
            }
        }
        return profit;
    }

    
}