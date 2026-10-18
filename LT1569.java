class Solution {
    static final int MOD = 1000000007;
    long[][] comb = new long[1001][1001];

    public int numOfWays(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        return (int) ((dfs(nums) - 1 + MOD) % MOD);
    }

    private long dfs(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return 1;
        }

        int root = nums[0];
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                leftCount++;
            } else {
                rightCount++;
            }
        }

        int[] left = new int[leftCount];
        int[] right = new int[rightCount];

        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left[l++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);

        return (((comb[leftCount + rightCount][leftCount] * leftWays) % MOD) * rightWays) % MOD;
    }
}
