class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(right, pile);
        }

        while(left < right){
            int middle = left + (right - left) / 2;

            int hourspent = 0;

            for(int pile : piles){
                hourspent += pile / middle + (pile % middle != 0 ? 1 : 0);
            }

            if(hourspent <= h){
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}