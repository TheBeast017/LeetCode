class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int duplicates = 1;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                String key = dx + "/" + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int max = 0;
            for (int val : map.values()) {
                max = Math.max(max, val);
            }

            ans = Math.max(ans, max + duplicates);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}