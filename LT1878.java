class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                set.add(grid[r][c]);

                for (int k = 1; r - k >= 0 && r + k < m && c - k >= 0 && c + k < n; k++) {
                    int sum = 0;

                    int i = r - k, j = c;
                    for (int d = 0; d < k; d++) sum += grid[i + d][j + d];

                    i = r; j = c + k;
                    for (int d = 0; d < k; d++) sum += grid[i + d][j - d];

                    i = r + k; j = c;
                    for (int d = 0; d < k; d++) sum += grid[i - d][j - d];

                    i = r; j = c - k;
                    for (int d = 0; d < k; d++) sum += grid[i - d][j + d];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] res = new int[size];
        int idx = 0;

        for (int val : set) {
            if (idx == 3) break;
            res[idx++] = val;
        }

        return res;
    }
}