class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int[] freq = new int[nums.length + 1];
        int left = 0;
        int distinct = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]]++ == 0) {
                distinct++;
            }

            while (distinct > k) {
                if (--freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
