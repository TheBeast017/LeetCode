class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i, dp));
        }

        return ans;
    }

    private int dfs(int[] arr, int d, int i, int[] dp) {
        if (dp[i] != 0) return dp[i];

        int n = arr.length;
        int res = 1;

        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, 1 + dfs(arr, d, j, dp));
        }

        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, 1 + dfs(arr, d, j, dp));
        }

        return dp[i] = res;
    }
}