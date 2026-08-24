class Solution {
    long[] c;

    public long findKthSmallest(int[] coins, int k) {
        c = new long[coins.length];
        for (int i = 0; i < coins.length; i++) c[i] = coins[i];

        long lo = 1, hi = 1L * coins[0] * k;
        for (long x : c) hi = Math.min(hi, x * k);

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (count(mid) >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    long count(long x) {
        long res = 0;
        int n = c.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    lcm = lcm(lcm, c[i]);
                    if (lcm > x) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                long add = x / lcm;
                if ((bits & 1) == 1) res += add;
                else res -= add;
            }
        }

        return res;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
