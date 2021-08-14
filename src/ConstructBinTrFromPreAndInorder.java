import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


//time O(n), space O(n)
public class ConstructBinTrFromPreAndInorder {
    int currentRootIdx;
    Map<Integer, Integer> inOrMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        currentRootIdx = 0;
        inOrMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inOrMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right){
        if(left > right) return null;

        int rootVal = preorder[currentRootIdx];
        currentRootIdx++;
        TreeNode newRoot = new TreeNode(rootVal);

        newRoot.left = buildTree(preorder, left, inOrMap.get(rootVal) - 1);
        newRoot.right = buildTree(preorder, inOrMap.get(rootVal) + 1, right);

        return newRoot;
    }
}
