import java.util.*;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Set<TreeNode> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : toDelete) set.add(i);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        ans.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println("cur = " + cur.val);
            if (set.contains(cur.val)) {
                ans.remove(cur);
                if (cur.left != null) {
                    ans.add(cur.left);
                }
                if (cur.right != null) {
                    ans.add(cur.right);
                }

            }
            if (cur.left != null) {
                queue.add(cur.left);
                if(set.contains(cur.left.val)) cur.left = null;

            }
            if (cur.right != null) {
                queue.add(cur.right);
                if(set.contains(cur.right.val)) cur.right = null;
            }

        }
        return new ArrayList<>(ans);
    }

    public List<TreeNode> delNodesRec(TreeNode root, int[] toDelete){
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : toDelete) set.add(i);
        dfs(set, ans, root);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }

    private TreeNode dfs(Set<Integer> set, List<TreeNode> ans, TreeNode root){
        if(root == null) return null;
        root.left = dfs(set, ans, root.left);
        root.right = dfs(set, ans, root.right);
        if(set.contains(root.val)){
            if(root.left != null) ans.add(root.left);
            if(root.right != null) ans.add(root.right);
            return null;
        }
        return root;
    }
}
