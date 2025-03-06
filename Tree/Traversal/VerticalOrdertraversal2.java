package Tree.Traversal;
import java.util.*;



class VerticalorderTraversal2 {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> verticalOrder(Node root) {
        Map<Integer, Map<Integer, List<Integer>>> nodes = new HashMap<>();
        Queue<Map.Entry<Node, Map.Entry<Integer, Integer>>> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        q.add(new AbstractMap.SimpleEntry<>(root, new AbstractMap.SimpleEntry<>(0, 0)));

        while (!q.isEmpty()) {
            Map.Entry<Node, Map.Entry<Integer, Integer>> temp = q.poll();
            Node frontNode = temp.getKey();  // isme key = node hai aur value = { verticle, levl} hai
            int hd = temp.getValue().getKey();  // vertcle
            int lvl = temp.getValue().getValue(); // level

            if (!nodes.containsKey(hd)) {
                nodes.put(hd, new HashMap<>());
            }

            if (!nodes.get(hd).containsKey(lvl)) {
                nodes.get(hd).put(lvl, new ArrayList<>());
            }

            nodes.get(hd).get(lvl).add(frontNode.val);

            if (frontNode.left != null) {
                q.add(new AbstractMap.SimpleEntry<>(frontNode.left, new AbstractMap.SimpleEntry<>(hd - 1, lvl + 1)));
            }

            if (frontNode.right != null) {
                q.add(new AbstractMap.SimpleEntry<>(frontNode.right, new AbstractMap.SimpleEntry<>(hd + 1, lvl + 1)));
            }
        }

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> i : nodes.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> j : i.getValue().entrySet()) {
                for (int k : j.getValue()) {
                    ans.add(k);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        //VerticalorderTraversal2 solution = new VerticalorderTraversal2();

        // Get the vertical order traversal
        List<Integer> verticalTraversal = verticalOrder(root);

        // Print the result
        System.out.print("Vertical Order Traversal: ");
        for (int node : verticalTraversal) {
            System.out.print(node + " ");
        }
    }
}
