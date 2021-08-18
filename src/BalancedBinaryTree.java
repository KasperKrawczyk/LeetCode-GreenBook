public class BalancedBinaryTree {
    // time O(n), space O(h), where h is the height of the tree
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;

        return computeBalance(root) != -1;
    }

    private int computeBalance(TreeNode node){
        if(node == null) return 0;
        int left = computeBalance(node.left);
        int right = computeBalance(node.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
