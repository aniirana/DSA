class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String y:operations){
            if(y.contains("++")){
                x++;
            }
            else{
                x--;
            }
        }
        return x;
    }
}