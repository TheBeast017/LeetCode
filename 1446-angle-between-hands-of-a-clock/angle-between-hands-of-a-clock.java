class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0;
        double minH = (6 * minutes);
        double hH = (30 * hour) + (0.5 * minutes);
        double potAns = Math.abs(hH  - minH);
        return Math.min(360 - potAns, potAns);


    }
}