/**
 * From Greenbook
 */
public class InorderSuccessor {
    class TreeNode {
        TreeNode parent;
        TreeNode leftChild;
        TreeNode rightChild;
        int val;

        public TreeNode(TreeNode parent, TreeNode leftChild, TreeNode rightChild, int val) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.val = val;
        }
    }
    // time O(log n), space O(log n)
    public TreeNode inorderSucc(TreeNode n){
        if(n == null) return null;

        if(n.rightChild != null){
            return leftmostChild(n.rightChild);
        // below we handle the case when n is a rightChild, so we need to find a parent which hasn't been traversed yet
        } else {
            TreeNode temp = n;
            TreeNode parent = temp.parent;
            while(parent != null && parent.leftChild != temp){
                temp = parent;
                parent.parent = parent;
            }
            return parent;
        }

    }

    private TreeNode leftmostChild(TreeNode n){
        if(n == null) return null;
        while(n.leftChild != null){
            n = n.leftChild;
        }
        return n;
    }
}
