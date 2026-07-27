class Solution {
    public int maxProduct(int[] nums) {
        int n = 0;
        int i = 0;
        while (i < nums.length) {
            if(nums[i] >= nums[n]) n = i;
            i++;
        }
        int n1 = nums[n];
        nums[n] = 0;
        i = 0;
        while (i < nums.length) {
            if(nums[i] >= nums[n]) n = i;
            i++;
        }
        return (n1 - 1) * (nums[n] - 1);
    }
}