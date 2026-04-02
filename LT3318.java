class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }

            list.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                return b[0] - a[0]; 
            });

            int sum = 0;
            for (int j = 0; j < Math.min(x, list.size()); j++) {
                int value = list.get(j)[0];
                int count = list.get(j)[1];
                sum += value * count;
            }

            ans[i] = sum;
        }

        return ans;
    }
}
