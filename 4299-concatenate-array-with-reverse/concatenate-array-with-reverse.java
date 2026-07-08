class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] arr = new int[nums.length*2];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
            arr[arr.length - i - 1] = nums[i];
        }
        return arr;
    }
}