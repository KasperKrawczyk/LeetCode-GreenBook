public class ValidateBST {

    // time O(n), space O(n)
    public boolean isValidBST(TreeNode root){
        return isValidRec(root.left, root.val, Long.MIN_VALUE) && isValidRec(root.right, Long.MAX_VALUE, root.val);
    }

    private boolean isValidRec(TreeNode node, long max, long min){
        if(node == null) {
            return true;
        }else if(node.val >= max || node.val <= min) {
            return false;
        } else {
            return isValidRec(node.left, node.val, min) && isValidRec(node.right, max, node.val);
        }
    }

}
