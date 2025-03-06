//package Tree.Traversal;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//// TreeNode structure
//
//
//public class Solution {
//    class Pair<T, U> {
//        T first;
//        U second;
//
//        public Pair(T first, U second) {
//            this.first = first;
//            this.second = second;
//        }
//
//        public U getValue() {
//            return null;
//        }
//
//        public T getKey() {
//            return null;
//        }
//    }
//    class TreeNode {
//        int val;
//        Node left;
//        Node right;
//
//        TreeNode(int x) {
//            val = x;
//            left = null;
//            right = null;
//        }
//    }
//
//    // Function widthOfBinaryTree to find the
//    // maximum width of the Binary Tree
//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int ans = 0;
//
//        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
//        q.add(new Pair<>(root, 0));
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            int mmin = q.peek().getValue();
//
//            int first = 0, last = 0; // Initialize first and last positions
//
//            for (int i = 0; i < size; i++) {
//                int cur_id = q.peek().getValue() - mmin;
//                TreeNode node = q.peek().getKey();
//                q.poll();
//
//                if (i == 0) {
//                    first = cur_id;
//                }
//
//                if (i == size - 1) {
//                    last = cur_id;
//                }
//
//                if (node.left != null) {
//                    q.add(new Pair<>(node.left, cur_id * 2 + 1));
//                }
//
//                if (node.right != null) {
//                    q.add(new Pair<>(node.right, cur_id * 2 + 2));
//                }
//            }
//
//            ans = Math.max(ans, last - first + 1);
//        }
//
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);
//
//        Solution sol = new Solution();
//
//        int maxWidth = sol.widthOfBinaryTree(root);
//
//        System.out.println("Maximum width of the binary tree is: " + maxWidth);
//    }
//}
//
