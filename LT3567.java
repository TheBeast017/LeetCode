class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int rows = m - k + 1;
        int cols = n - k + 1;

        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int size = k * k;
                int[] arr = new int[size];
                int idx = 0;
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        arr[idx++] = grid[x][y];
                    }
                }

                Arrays.sort(arr);
                int uniqueSize = 1;
                for (int t = 1; t < size; t++) {
                    if (arr[t] != arr[t - 1]) {
                        arr[uniqueSize++] = arr[t];
                    }
                }
                if (uniqueSize <= 1) {
                    ans[i][j] = 0;
                } else {
                    int minDiff = Integer.MAX_VALUE;
                    for (int t = 1; t < uniqueSize; t++) {
                        minDiff = Math.min(minDiff, arr[t] - arr[t - 1]);
                    }
                    ans[i][j] = minDiff;
                }
            }
        }

        return ans;
    }
}
