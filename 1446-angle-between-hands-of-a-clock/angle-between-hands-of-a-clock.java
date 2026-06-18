class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0;
        double potAns = Math.abs((30 * hour) + (0.5 * minutes) - (6 * minutes));
        return Math.min(360 - potAns, potAns);


    }
}