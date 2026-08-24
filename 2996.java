class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        boolean[] present = new boolean[101];

        for (int num : nums) {
            if (num <= 100) {
                present[num] = true;
            }
        }

        while (sum <= 100 && present[sum]) {
            sum++;
        }

        return sum;
    }
}
