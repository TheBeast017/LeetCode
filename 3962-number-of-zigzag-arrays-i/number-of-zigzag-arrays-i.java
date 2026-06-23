class Solution {
    public int zigZagArrays(int n, int l, int r) {
        long mod = 1_000_000_007L;
        int m = r - l + 1;

        if (n == 1) return m;
        if (n == 2) return (int) ((long) m * (m - 1) % mod);

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long[] prefixDown = new long[m + 1];
            long[] prefixUp = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                prefixDown[v] = (prefixDown[v - 1] + down[v]) % mod;
                prefixUp[v] = (prefixUp[v - 1] + up[v]) % mod;
            }

            long totalUp = prefixUp[m];

            for (int v = 1; v <= m; v++) {
                newUp[v] = prefixDown[v - 1];
                newDown[v] = (totalUp - prefixUp[v] + mod) % mod;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % mod;
        }

        return (int) ans;
    }
}