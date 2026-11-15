class Solution {

    public int numOfSubarrays(int[] arr) {

        final int MOD = 1_000_000_007;

        long ans = 0;
        long even = 1;
        long odd = 0;

        int sum = 0;

        for (int x : arr) {

            sum += x;

            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }

            ans %= MOD;
        }

        return (int) ans;
    }
}
