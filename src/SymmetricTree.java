import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    // time O(n), space O(n)
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
