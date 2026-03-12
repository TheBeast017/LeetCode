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
class Solution{
    public int goodNodes(TreeNode root){
        return dfs(root,Integer.MIN_VALUE);
    }
    int dfs(TreeNode node,int max){
        if(node==null)return 0;
        int c=0;
        if(node.val>=max){
            c=1;
            max=node.val;
        }
        c+=dfs(node.left,max);
        c+=dfs(node.right,max);
        return c;
    }
}
