class Solution {
    public int longestBalanced(String s) {
        int ans = s.isEmpty() ? 0 : 1;

        int run = 1;
        for (int i = 1; i < s.length(); i++) {
            run = (s.charAt(i) == s.charAt(i - 1)) ? run + 1 : 1;
            ans = Math.max(ans, run);
        }

        ans = Math.max(ans, longestTwoChar(s, 'a', 'b'));
        ans = Math.max(ans, longestTwoChar(s, 'b', 'c'));
        ans = Math.max(ans, longestTwoChar(s, 'a', 'c'));
        ans = Math.max(ans, longestThreeChar(s));

        return ans;
    }

    private int longestTwoChar(String s, char c1, char c2) {
        int ans = 0, start = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || (s.charAt(i) != c1 && s.charAt(i) != c2)) {
                ans = Math.max(ans, longestEqualCounts(s, start, i, c1, c2));
                start = i + 1;
            }
        }
        return ans;
    }

    private int longestEqualCounts(String s, int l, int r, char c1, char c2) {
        Map<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, l - 1);
        int diff = 0, ans = 0;
        for (int i = l; i < r; i++) {
            diff += (s.charAt(i) == c1) ? 1 : -1;
            if (firstSeen.containsKey(diff)) {
                ans = Math.max(ans, i - firstSeen.get(diff));
            } else {
                firstSeen.put(diff, i);
            }
        }
        return ans;
    }

    private int longestThreeChar(String s) {
        Map<Long, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0L, -1);
        int ca = 0, cb = 0, cc = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if      (c == 'a') ca++;
            else if (c == 'b') cb++;
            else               cc++;
            long key = (long)(ca - cb) * 200_001L + (cb - cc);
            if (firstSeen.containsKey(key)) {
                ans = Math.max(ans, i - firstSeen.get(key));
            } else {
                firstSeen.put(key, i);
            }
        }
        return ans;
    }
}
