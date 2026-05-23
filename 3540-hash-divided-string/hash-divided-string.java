class Solution {
    public String stringHash(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += s.charAt(j) - 'a';
            }
            res.append((char) ('a' + (sum % 26)));
        }
        return res.toString();
    }
}