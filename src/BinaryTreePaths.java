import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    // time O(n), space O(n)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        dfs(ans, "", root);
        return ans;
    }

    private void dfs(List<String> ans, String cur, TreeNode root){
        cur += root.val;
        if(root.left == null && root.right == null){
            ans.add(cur);
            return;
        }

        if(root.left != null){
            dfs(ans, cur + "->", root.left);
        }
        if(root.right != null){
            dfs(ans, cur  + "->", root.right);
        }
    }
}
