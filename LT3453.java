class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0;
        double low = Double.MAX_VALUE;
        double high = 0;
        for (int[] s : squares) {
            total += (double) s[2] * s[2];
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }
        double target = total / 2.0;
        for (int i = 0; i < 80; i++) {
            double mid = (low + high) / 2.0;
            double area = 0;
            for (int[] s : squares) {
                if (mid <= s[1]) {
                    continue;
                } else if (mid >= s[1] + s[2]) {
                    area += (double) s[2] * s[2];
                } else {
                    area += (mid - s[1]) * s[2];
                }
            }
            if (area < target) low = mid;
            else high = mid;
        }
        return low;
    }
}
