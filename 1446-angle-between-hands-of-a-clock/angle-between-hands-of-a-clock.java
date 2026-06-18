class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12;
        double minH = (6 * minutes);
        double hH = (30 * hour) + (0.5 * minutes);
        double potAns = Math.abs(hH  - minH);
        return Math.min(360 - potAns, potAns);


    }
}