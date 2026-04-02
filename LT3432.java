class Solution {
    public int countPartitions(int[] nums) {
        int left = nums[0];
        int right = 0;
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            right+=nums[i];
        }
        for(int i = 1; i < nums.length; i++){
            if(Math.abs(left-right)%2==0){
                count++;
            }
            left+=nums[i];
            right-=nums[i];
        }
        return count;
    }
}
