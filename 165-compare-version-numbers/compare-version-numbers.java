class Solution {
    public int compareVersion(String v1, String v2) {
        String[] a = v1.split("\\."), b = v2.split("\\.");
        int n = Math.max(a.length, b.length);
        for (int i = 0; i < n; i++) {
            int x = i < a.length ? Integer.parseInt(a[i]) : 0;
            int y = i < b.length ? Integer.parseInt(b[i]) : 0;
            if (x != y) return x > y ? 1 : -1;
        }
        return 0;
    }
}