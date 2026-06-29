class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int start=1;
        int end=0;

        for(int pile:piles){
            end=Math.max(end,pile);
        }
        while(start<end){
            int mid=start+(end-start)/2;
            int hr=0;
            for(int pile:piles){
                hr+=(int)Math.ceil((double)pile/mid);
            }
            if(hr>h){
                start=mid+1;
            }
            else {
                end=mid;
            }
        }
        return end;
        
    }
}