class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, "", res);
        return res;
    }
    public void backtrack(int n, String cur, List<String> res) {
        if (cur.length() == n) {
            res.add(cur);
            return;
        }
        backtrack(n, cur + "1", res);
        if (cur.length() == 0 || cur.charAt(cur.length() - 1) != '0') {
            backtrack(n, cur + "0", res);
        }
    }
}
