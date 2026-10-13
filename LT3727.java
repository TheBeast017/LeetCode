class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0 ; i < nums.length; i++) nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        long greater = 0, smaller = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i >= nums.length / 2) greater += nums[i];
            else smaller += nums[i];
        }
        return greater - smaller;
    }
}
