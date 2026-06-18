class Solution {
    public double angleClock(int hour, int min) {
        //0.5 deg fot hour hand
        //6 deg for min hand
        double hr=30*hour;
        double minute=5.5*min;
        
        double angle=Math.abs(hr-minute);
        double maxang=Math.min(angle,360-angle);
        return maxang;
        
        
    }
}