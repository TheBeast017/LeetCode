class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int[] freq = new int[mx + 1];
        for (int x : nums) freq[x]++;

        long[] cnt = new long[mx + 1];
        for (int g = 1; g <= mx; g++) {
            long c = 0;
            for (int j = g; j <= mx; j += g) c += freq[j];
            cnt[g] = c * (c - 1) / 2;
        }

        long[] exact = new long[mx + 1];
        for (int g = mx; g >= 1; g--) {
            long v = cnt[g];
            for (int j = g + g; j <= mx; j += g) v -= exact[j];
            exact[g] = v;
        }

        long[] pref = new long[mx + 1];
        for (int g = 1; g <= mx; g++) pref[g] = pref[g - 1] + exact[g];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1;
            int l = 1, r = mx;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (pref[mid] >= k) r = mid;
                else l = mid + 1;
            }
            ans[i] = l;
        }
        return ans;
    }
}
