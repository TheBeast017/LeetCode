class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, n);
        Arrays.fill(right, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {
            if (right[c] == -1) continue;
            int l = left[c], r = right[c];
            boolean valid = true;
            for (int i = l; i <= r && valid; i++) {
                int x = s.charAt(i) - 'a';
                if (left[x] < l) {
                    valid = false;
                    break;
                }
                r = Math.max(r, right[x]);
            }
            if (valid) intervals.add(new int[]{l, r});
        }

        intervals.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        List<String> ans = new ArrayList<>();
        int end = -1;
        for (int[] in : intervals) {
            if (in[0] > end) {
                ans.add(s.substring(in[0], in[1] + 1));
                end = in[1];
            }
        }
        return ans;
    }
}
