class Solution {
    static final int BIG_NUM = 100001;

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;

        int[] bottom = new int[BIG_NUM], top = new int[BIG_NUM];

        for (int[] row : grid) {
            for (int x : row) {
                total += x;
                bottom[x]++;
            }
        }

        long top_sum = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                top_sum += val;
                top[val]++;
                bottom[val]--;
            }

            long bottom_sum = total - top_sum;
            if (top_sum == bottom_sum) return true;

            long diff = Math.abs(top_sum - bottom_sum);

            if (diff < BIG_NUM) {
                if (top_sum > bottom_sum) {
                    if (check(top, grid, 0, i, 0, n - 1, diff)) return true;
                } else {
                    if (check(bottom, grid, i + 1, m - 1, 0, n - 1, diff)) return true;
                }
            }
        }

        int[] left = new int[BIG_NUM], right = new int[BIG_NUM];

        for (int[] row : grid) {
            for (int x : row) {
                right[x]++;
            }
        }

        long left_sum = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                left_sum += val;
                left[val]++;
                right[val]--;
            }

            long right_sum = total - left_sum;
            if (left_sum == right_sum) return true;

            long diff = Math.abs(left_sum - right_sum);

            if (diff < BIG_NUM) {
                if (left_sum > right_sum) {
                    if (check(left, grid, 0, m - 1, 0, j, diff)) return true;
                } else {
                    if (check(right, grid, 0, m - 1, j + 1, n - 1, diff)) return true;
                }
            }
        }

        return false;
    }

    public boolean check(int[] freq, int[][] grid, int r1, int r2, int c1, int c2, long diff) {
        if (diff >= BIG_NUM || freq[(int) diff] == 0) return false;

        int rows = r2 - r1 + 1, cols = c2 - c1 + 1;

        if (rows == 1) {
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }

        if (cols == 1) {
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }

        for (int j = c1; j <= c2; j++) {
            if (grid[r1][j] == diff || grid[r2][j] == diff) return true;
        }

        for (int i = r1; i <= r2; i++) {
            if (grid[i][c1] == diff || grid[i][c2] == diff) return true;
        }

        return false;
    }
}
