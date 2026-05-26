class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, lo = 0, hi = n;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (citations[n - mid] >= mid) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}