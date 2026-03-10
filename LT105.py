class Solution(object):
    def buildTree(self, preorder, inorder):
        inorder_map = {v: i for i, v in enumerate(inorder)}
        self.pre_index = 0
        def helper(left, right):
            if left > right:
                return None

            root_val = preorder[self.pre_index]
            self.pre_index += 1
            root = TreeNode(root_val)

            mid = inorder_map[root_val]
            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)

            return root
        return helper(0, len(inorder) - 1)
