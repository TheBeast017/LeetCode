class Solution {
    public int smallestNumber(int n, int t) {
        int val = 1;
        int temp = n;
        while (temp != 0) {
            val *= (temp % 10);
            temp /= 10;
        }
        if (val % t == 0) return n;
        return smallestNumber(n + 1, t);
    }
}
