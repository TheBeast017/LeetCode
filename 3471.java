class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[51];

        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    count[nums[j]]++;
                    seen[nums[j]] = true;
                }
            }
        }

        int ans = -1;

        for (int x = 0; x <= 50; x++) {
            if (count[x] == 1) {
                ans = x;
            }
        }

        return ans;
    }
}
