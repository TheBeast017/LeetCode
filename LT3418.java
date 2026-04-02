class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int NEG = -1_000_000_000;

        int[][] prev = new int[n][3];
        int[][] curr = new int[n][3];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < 3; k++) {
                prev[j][k] = NEG;
                curr[j][k] = NEG;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    curr[j][k] = NEG;
                }

                int val = coins[i][j];

                if (i == 0 && j == 0) {
                    curr[j][0] = val;
                    if (val < 0) {
                        curr[j][1] = 0;
                    }
                    continue;
                }

                for (int k = 0; k < 3; k++) {
                    if (prev[j][k] != NEG) {
                        curr[j][k] = Math.max(curr[j][k], prev[j][k] + val);
                    }
                    if (j > 0 && curr[j - 1][k] != NEG) {
                        curr[j][k] = Math.max(curr[j][k], curr[j - 1][k] + val);
                    }
                    if (val < 0 && k > 0) {
                        if (prev[j][k - 1] != NEG) {
                            curr[j][k] = Math.max(curr[j][k], prev[j][k - 1]);
                        }
                        if (j > 0 && curr[j - 1][k - 1] != NEG) {
                            curr[j][k] = Math.max(curr[j][k], curr[j - 1][k - 1]);
                        }
                    }
                }
            }

            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        return Math.max(prev[n - 1][0], Math.max(prev[n - 1][1], prev[n - 1][2]));
    }
}
