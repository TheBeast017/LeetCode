class Solution {
    static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] next = new int[n + 1];
        int[] prev = new int[n];
        next[n] = -1;
        int last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') last = i;
            next[i] = last;
        }
        last = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') last = i;
            prev[i] = last;
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') k++;
        }

        int[] idx = new int[n];
        long[] pow10 = new long[k + 1];
        long[] pref = new long[k + 1];
        int[] sum = new int[k + 1];
        pow10[0] = 1;

        int t = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                idx[i] = t;
                int d = s.charAt(i) - '0';
                pow10[t + 1] = pow10[t] * 10 % MOD;
                pref[t + 1] = (pref[t] * 10 + d) % MOD;
                sum[t + 1] = sum[t] + d;
                t++;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = next[queries[i][0]];
            int r = prev[queries[i][1]];
            if (l == -1 || r == -1 || l > r) {
                ans[i] = 0;
                continue;
            }
            int a = idx[l];
            int b = idx[r];
            long x = (pref[b + 1] - pref[a] * pow10[b - a + 1]) % MOD;
            if (x < 0) x += MOD;
            long digitSum = sum[b + 1] - sum[a];
            ans[i] = (int) (x * digitSum % MOD);
        }
        return ans;
    }
}