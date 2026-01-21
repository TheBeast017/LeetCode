/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDiff = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return maxDiff;
    }
    public void dfs(TreeNode node, int minVal, int maxVal) {
        if (node == null) return;
        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);
        maxDiff = Math.max(maxDiff, maxVal - minVal);
        dfs(node.left, minVal, maxVal);
        dfs(node.right, minVal, maxVal);
    }
}
