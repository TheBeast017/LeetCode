class Solution {
    long total = 0;
    long ans = 0;
    public int maxProduct(TreeNode root) {
        totalSum(root);
        dfs(root);
        return (int)(ans % 1_000_000_007);
    }
    private void totalSum(TreeNode node) {
        if (node == null) return;
        total += node.val;
        totalSum(node.left);
        totalSum(node.right);
    }
    private long dfs(TreeNode node) {
        if (node == null) return 0;
        long left = dfs(node.left);
        long right = dfs(node.right);
        long cur = node.val + left + right;
        ans = Math.max(ans, cur * (total - cur));
        return cur;
    }
}
