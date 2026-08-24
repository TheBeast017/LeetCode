// class Solution {
//     public int maxSubarrayLength(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         if (nums.length <= 1) return nums.length;
//         map.put(nums[0], 1);
//         int i = 0, j = 1;
//         int maxm = 0;
//         while (j < nums.length) {
//             if (map.containsKey(nums[j])) {
//                 if (map.get(nums[j]) < k) {
//                     map.put(nums[j], map.get(nums[j]) + 1);
//                     maxm = Math.max(maxm, j - i + 1);
//                     j++;
//                 } else {
//                     map.put(nums[i], map.get(nums[i])-1);
//                     i++;
//                 }
//             } else {
//                 map.put(nums[j], 1);
//                 j++;
//             }
//         }
//         return maxm;
//     }
// }
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int maxm = 0;

        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            maxm = Math.max(maxm, j - i + 1);
        }

        return maxm;
    }
}
