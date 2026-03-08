class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack=new Stack<>();
        int i=0,n=traversal.length();
        while(i<n){
            int depth=0;
            while(i<n&&traversal.charAt(i)=='-'){
                depth++;
                i++;
            }
            int val=0;
            while(i<n&&Character.isDigit(traversal.charAt(i))){
                val=val*10+(traversal.charAt(i)-'0');
                i++;
            }
            TreeNode node=new TreeNode(val);
            while(stack.size()>depth)stack.pop();
            if(!stack.isEmpty()){
                if(stack.peek().left==null)stack.peek().left=node;
                else stack.peek().right=node;
            }stack.push(node);
        }
        while(stack.size()>1)stack.pop();
        return stack.peek();
    }
}
