public class SameTree {
    //time O(n), space O(log n) on a balanced tree, O(n) on an worst-case unbalanced tree
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
