class Solution {
    public int maxScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int c = 0; c <= k; c++)
                    dp[i][j][c] = -1;

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue;

                    if (i + 1 < m) {
                        int cost = (grid[i + 1][j] == 0) ? 0 : 1;
                        int score = grid[i + 1][j];
                        if (c + cost <= k) {
                            dp[i + 1][j][c + cost] = Math.max(dp[i + 1][j][c + cost], dp[i][j][c] + score);
                        }
                    }

                    if (j + 1 < n) {
                        int cost = (grid[i][j + 1] == 0) ? 0 : 1;
                        int score = grid[i][j + 1];
                        if (c + cost <= k) {
                            dp[i][j + 1][c + cost] = Math.max(dp[i][j + 1][c + cost], dp[i][j][c] + score);
                        }
                    }
                }
            }
        }

        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans;
    }
}
