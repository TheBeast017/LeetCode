class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0, j = 0; i < nums.length && j < 2 ; i++){
            if(!map.add(nums[i])){
                ans[j++]=nums[i];
            }
        }
        return ans;
    }
}
