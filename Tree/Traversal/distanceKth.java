package Tree.Traversal;

import java.util.*;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null; // Initialize left node
        right = null; // Initialize right node
    }
}

public class distanceKth {
     //same as burun tree in gfg
    private static void markParents(Node root, Map<Node, Node> parent_track, Node target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                parent_track.put(current.left, current); // Mapping parent to correct left child
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current); // Mapping parent to correct right child
                queue.offer(current.right);
            }
        }
    }

    public static List<Integer> distanceK(Node root, Node target, int k) {

        // ye Map nodes ko unke parents se Map krega
        Map<Node, Node> parent_track = new HashMap<>();

        //ab ye function call hoga aur humko parents se mapping krke dega
        markParents(root, parent_track, target);

        // ye visited check krega  jo visit ho jaayga usko visit nhi krenge
        Map<Node, Boolean> visited = new HashMap<>();
        // aur visit karne ke liye ye Queue kaam aayga
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);

        int curr_level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr_level == k) break;
            curr_level++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                Node parent = parent_track.get(current);
                if (parent != null && visited.get(parent) == null) {
                    queue.offer(parent);
                    visited.put(parent, true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.val);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage of distanceK method
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        Node target = root.left;
        int k = 2;
        List<Integer> result = distanceK(root, target, k);
        System.out.println("Nodes at distance " + k + " from target " + target.val + ": " + result);
    }
}

