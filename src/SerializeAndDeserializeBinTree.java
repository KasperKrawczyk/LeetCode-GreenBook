import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinTree {
    public class Codec {

        public static final String NULL_NODE = "X";
        public static final String SPLIT_VALUE = ",";

        // Encodes a tree to a single string.
        //time O(n), space O(n)
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            serializeUtil(root, stringBuilder);
            return stringBuilder.toString();
        }

        // pre-order traversal produces a string unique to a tree
        private void serializeUtil(TreeNode root, StringBuilder stringBuilder){
            if(root == null){
                stringBuilder.append(NULL_NODE);
                stringBuilder.append(SPLIT_VALUE);
            } else {
                stringBuilder.append(root.val);
                stringBuilder.append(SPLIT_VALUE);
                serializeUtil(root.left, stringBuilder);
                serializeUtil(root.right, stringBuilder);
            }
        }

        // Decodes your encoded data to tree.
        //time O(n), space O(n)
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(data.split(SPLIT_VALUE)));
            return deserializeUtil(queue);
        }

        private TreeNode deserializeUtil(Queue<String> queue){
            String curNodeVal = queue.poll();
            if(curNodeVal.equals(NULL_NODE)){
                return null;
            } else {
                TreeNode curNode = new TreeNode(Integer.parseInt(curNodeVal));
                curNode.left = deserializeUtil(queue);
                curNode.right = deserializeUtil(queue);
                return curNode;
            }
        }
    }
}
