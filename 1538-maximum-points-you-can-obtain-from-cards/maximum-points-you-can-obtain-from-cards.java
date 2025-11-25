class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0;
        int sum=0;
        int maxsum=Integer.MAX_VALUE;;

        for(int right=0;right<cardPoints.length;right++){
            sum+=cardPoints[right];

            while(right-left+1>cardPoints.length-k){
                sum-=cardPoints[left];
                left++;
            }

            if(right-left+1==cardPoints.length-k){
                maxsum=Math.min(maxsum,sum);
            }

            
        }

        int total = 0;
        for (int x : cardPoints){
            total += x;
        } 
            
        return total-maxsum;
        
    }
}