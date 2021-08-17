import java.util.*;

public class ConstructBinTrFromPostAndInorder {
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

        newRoot.left = buildTree(postorder, inorMap, postIdx - (inorEnd - inorderIdx  + 1), inorStart, inorderIdx - 1);
        newRoot.right = buildTree(postorder, inorMap, postIdx - 1,inorderIdx + 1, inorEnd);

        return newRoot;
    }
}
