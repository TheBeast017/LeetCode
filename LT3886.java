
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] drop = new int[n];

        suffMin[n] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);

        for (int i = n - 1; i >= 0; i--)
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);

        for (int i = 1; i < n; i++)
            drop[i] = drop[i - 1]
                    + (nums[i - 1] > nums[i] ? 1 : 0);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean ok = true;

            for (int i = 0; i < n; i += k) {
                int j = i + k - 1;

                int decreases = drop[j] - drop[i];
                decreases += nums[j] > nums[i] ? 1 : 0;

                if (decreases > 1) {
                    ok = false;
                    break;
                }

                if (i > 0 && prefMax[i] > suffMin[i]) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans += k;
        }

        return ans;
    }
}
