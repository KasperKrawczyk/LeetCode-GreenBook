public class SumOfNodesWithEvenValuedGrandparent {

    // time O(n), space O(n)
    public int sumEvenGrandparent(TreeNode root) {
        return rec(null, null, root);
    }

    public int rec(TreeNode grandparent, TreeNode parent, TreeNode root){
        if(root == null){
            return 0;
        }
        int val = 0;
        if(grandparent != null){
            val = grandparent.val % 2 == 0 ? root.val : 0;
        }
        return rec(parent, root, root.left) + rec(parent, root, root.right) + val;
    }
}
