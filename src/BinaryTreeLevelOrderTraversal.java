import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // time O(n), space O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode cur = queue.poll();
                levelList.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            ans.add(levelList);
        }
        return ans;
    }
}
