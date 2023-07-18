/**
 * From Greenbook and Leetcode
 */
public class LowestCommonAncestor {
    //time O(n), space O(h), where n is the number of nodes, and h is the height of the tree
    public TreeNode recursive(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left = recursive(root.left, p, q);
        TreeNode right = recursive(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}
