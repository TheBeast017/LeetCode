class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            while (nums[i] > 0) {
                temp.add(nums[i] % 10);
                nums[i] /= 10;
            }
            Collections.reverse(temp);
            list.addAll(temp);
        }
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}