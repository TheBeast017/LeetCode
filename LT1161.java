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
    public int maxLevelSum(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        int lvl=1, ans=1, max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int sn = q.size(), sum = 0;
            for(int i=0; i<sn; i++){
            TreeNode n=q.poll();
            sum+=n.val;
            if(n.left!=null) q.offer(n.left);
            if(n.right!=null) q.offer(n.right);
        }
        if(sum>max){ max=sum; ans=lvl;}
        lvl++;
        }
        return ans;
    }
}