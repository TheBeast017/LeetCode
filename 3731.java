class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int maxm = 0, minm = Integer.MAX_VALUE;
        for (int num : nums) {
            maxm = Math.max(maxm, num);
            minm = Math.min(minm, num);
        }
        for (int i = minm; i <= maxm; i++) {
            l.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(l.indexOf(nums[i]) != -1) l.remove(l.indexOf(nums[i]));
        }
        return l;
    }
}
