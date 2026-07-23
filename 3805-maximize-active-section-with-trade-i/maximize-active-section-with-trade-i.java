class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";
        int m = t.length();

        java.util.ArrayList<Integer> lens = new java.util.ArrayList<>();
        java.util.ArrayList<Character> type = new java.util.ArrayList<>();

        int i = 0;
        while (i < m) {
            char c = t.charAt(i);
            int j = i;
            while (j < m && t.charAt(j) == c) j++;
            type.add(c);
            lens.add(j - i);
            i = j;
        }

        int ans = ones;

        for (int k = 1; k < lens.size() - 1; k++) {
            if (type.get(k) == '1' && type.get(k - 1) == '0' && type.get(k + 1) == '0') {
                int gain = lens.get(k - 1) + lens.get(k + 1);
                ans = Math.max(ans, ones + gain);
            }
        }

        return Math.min(ans, n);
    }
}