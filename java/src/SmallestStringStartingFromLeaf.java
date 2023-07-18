

public class SmallestStringStartingFromLeaf {
    // time O(n), space O(n)
    public String smallestFromLeaf(TreeNode root) {
        String[] ans = new String[] {null};
        dfs(ans, "", root);
        return ans[0];

    }

    private void dfs(String[] ans, String curPath, TreeNode root){
        if(root == null) return;
        char cur = (char) (root.val + 'a');
        curPath = cur + curPath;
        if(root.left == null && root.right == null){
            if(ans[0] == null || ans[0].compareTo(curPath) > 0){
                ans[0] = curPath;
            }

        } else {
            dfs(ans, curPath, root.left);
            dfs(ans, curPath, root.right);
        }
    }

}
