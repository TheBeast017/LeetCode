class Solution {
    public int twoEggDrop(int n) {
        long[] dp = new long[3];
        int moves = 0;

        while (dp[2] < n) {
            moves++;
            for (int i = 2; i >= 1; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
        }
        return moves;
    }
    
}
