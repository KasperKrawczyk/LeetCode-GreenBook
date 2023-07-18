import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<Node>();
        }
        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    // time O(num_verteces), space O(num_verteces)
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            for (Node neighbor : curNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);

                }
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
