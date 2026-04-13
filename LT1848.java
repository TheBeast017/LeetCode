class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int i  = start, j = start-1;
        int ans = Integer.MAX_VALUE;;
        while(i<nums.length){
            if(nums[i] == target){
                ans = i - start;
                break;
            }
            i++;
        }
        while(j>=0){
            if(nums[j] == target){
                ans = Math.min(ans, start-j);
                break;
            }
            j--;
        }
        return ans;
    }
}
