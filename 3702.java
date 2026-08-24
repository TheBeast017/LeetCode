class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        if (xor != 0) {
            return nums.length;
        }
        for (int num : nums) {
            if (num != 0) {
                return nums.length - 1;
            }
        }
        return 0;
    }
}
