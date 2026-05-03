class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        while (left <= right) {
            if (isPrime(getBits(left, 0))) count++;
            left++;
        }
        return count;
    }

    private static int getBits(int n, int c) {
        if (n == 0) return c;
        c += (n & 1);
        return getBits(n >> 1, c);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
