class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxDiff = 0;
        for(int i = 0; i < nums.length -1 ; i++){
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i+1]));
        }
        return maxDiff;
    }
}
