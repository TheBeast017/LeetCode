class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] arr = new int[nums.length];
        return transformedArray(nums, arr, 0);
    }
    public int[] transformedArray(int[] nums, int[] arr, int i){
        if (i == nums.length) return arr;
        int val = nums[i];
        if (val < 0) {

            val = i-(Math.abs(val)%nums.length);
            val+=nums.length;
        }else {
            val += i;
        }
        val %= nums.length;
        arr[i] = nums[val];
        return transformedArray(nums, arr, i+1);
    }
}
