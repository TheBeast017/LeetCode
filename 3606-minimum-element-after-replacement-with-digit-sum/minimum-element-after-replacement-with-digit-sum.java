class Solution {
    public int minElement(int[] nums) {
        int i = 0;
        int ans = Integer.MAX_VALUE;
        while(i < nums.length){
            int sum = 0;
            while(nums[i] != 0) {
                sum += (nums[i] % 10);
                nums[i] /= 10;
            }
            ans = Math.min(ans, sum);
            i++;
        }
        return ans;
    }
}