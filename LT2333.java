class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] freq = new int[100001];

        for (int i = 0; i < n; i++) {
            freq[Math.abs(nums1[i] - nums2[i])]++;
        }

        for (int d = 100000; d > 0 && k > 0; d--) {
            if (freq[d] == 0) {
                continue;
            }

            long count = freq[d];
            long move = Math.min(k, count);

            freq[d] -= (int) move;
            freq[d - 1] += (int) move;
            k -= move;
        }

        long result = 0;

        for (int d = 1; d <= 100000; d++) {
            result += (long) d * d * freq[d];
        }

        return result;
    }
}
