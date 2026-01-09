# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def lcaDeepestLeaves(self, root):
        def dfs(node):
            if not node:
                return 0, None
            ld, ln = dfs(node.left)
            rd, rn = dfs(node.right)
            if ld > rd:
                return ld + 1, ln
            if rd > ld:
                return rd + 1, rn
            return ld + 1, node
        return dfs(root)[1]
