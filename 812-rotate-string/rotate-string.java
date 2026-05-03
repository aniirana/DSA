class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!= goal.length()){
            return false;
        }
        String sdouble=s+s;

        return sdouble.contains(goal);
    }
}