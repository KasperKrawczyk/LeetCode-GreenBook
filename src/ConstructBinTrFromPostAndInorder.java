import java.util.*;

public class ConstructBinTrFromPostAndInorder {
    // time o(n), space O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorMap.put(inorder[i], i);
        }
        return buildTree(postorder, inorMap, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> inorMap,
                               int postIdx,
                               int inorStart, int inorEnd){
        if(postIdx < 0 || inorStart > inorEnd) return null;
        int rootVal = postorder[postIdx];
        TreeNode newRoot = new TreeNode(rootVal);
        int inorderIdx = inorMap.get(rootVal);
        // to extract the index of the left subtree's root from the postorder array we can leverage the fact
        // that both arrays are the same length, so we can subtract from the current postIdx the difference
        // of the current end of the inorder array's subsection and inorderIdx ( + 1)
        newRoot.left = buildTree(postorder, inorMap, postIdx - (inorEnd - inorderIdx  + 1), inorStart, inorderIdx - 1);
        newRoot.right = buildTree(postorder, inorMap, postIdx - 1,inorderIdx + 1, inorEnd);

        return newRoot;
    }
}
