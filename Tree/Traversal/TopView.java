package Tree.Traversal;
import java.util.*;



public class TopView {
    // Node structure for the binary tree
    public class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize the node with a value
        public Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    // Custom Pair class to pair up Node with its vertical position
    class Pair<T, U> {
        T first;
        U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    // Function to return the top view of the binary tree
    public List<Integer> topView(Node root) {
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if (root == null) {
            return ans;
        }

        // Map to store the top view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each element
        // is a pair containing node
        // and its vertical position
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.first;
            int line = pair.second;

            // If the vertical position is not already
            // in the map, add the node's data to the map
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            // Process left child
            if (node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Transfer values from the
        // map to the result list
        for (int value : mpp.values()) {
            ans.add(value);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TopView topView = new TopView();
        TopView.Node root = topView.new Node(1);
        root.left = topView.new Node(2);
        root.left.left = topView.new Node(4);
        root.left.right = topView.new Node(10);
        root.left.left.right = topView.new Node(5);
        root.left.left.right.right = topView.new Node(6);
        root.right = topView.new Node(3);
        root.right.right = topView.new Node(10);
        root.right.left = topView.new Node(9);

        // Get the top view traversal
        List<Integer> topViewResult = topView.topView(root);

        // Print the result
        System.out.println("Vertical Traversal: ");
        for (int node : topViewResult) {
            System.out.print(node + " ");
        }
    }
}
