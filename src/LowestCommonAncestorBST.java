public class LowestCommonAncestorBST {
    // time O(log n), space O(1)
    // all values are unique, p != q, and both p and q exist in the tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if(rootVal > pVal && rootVal > qVal){
            return lowestCommonAncestor(root.left, p, q);
        } else if(rootVal < pVal && rootVal < qVal){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
