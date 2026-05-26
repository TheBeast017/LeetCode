class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackComb(k, n, 1, new ArrayList<>(), res);
        return res;
    }
    private void backtrackComb(int k, int n, int start, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k && n == 0) { res.add(new ArrayList<>(cur)); return; }
        if (cur.size() == k || n <= 0) return;
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            backtrackComb(k, n - i, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}