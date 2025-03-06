package Tree;

public class largestBST {

    //ye humne node ka constructor bana diya
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    //ye humne reult naam ka constructor banaya jo ki min, max ka pata lgaayga aur bataayga ki valid BST hai ya nhi
    static class Result {
        boolean isBst = true; // ye batayga ki valid bst subtree hai ya nhi woto baadme chck hoga kon chhota hai kon
        // bada
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCount = 0;  // ismme hum size dhekenge bst ka
    }

    static Result largestBstWithResult(Node node) {
        // ye hai main function
        if (node == null)
            // return new (Integer.MIN_VALUE, Integer.MAx_VALUE, maxCount);
            return new Result();

        Result leftRes = largestBstWithResult(node.left);
        Result rightRes = largestBstWithResult(node.right);

        //isme sab wo likha hai joki valid BST ke liye nhi honi chaiye agar ek bhi true hui to woh BST nhi hai
        if (!leftRes.isBst || !rightRes.isBst || leftRes.max >= node.data || node.data >= rightRes.min) {
            leftRes.isBst = false;
            leftRes.maxCount = Math.max(leftRes.maxCount, rightRes.maxCount);
        } else {
            leftRes.min = Math.min(leftRes.min, node.data);
            leftRes.max = Math.max(rightRes.max, node.data);
            leftRes.maxCount = leftRes.maxCount + rightRes.maxCount + 1;
        }

        return leftRes;
    }
    static int largestBst(Node root) {
        return largestBstWithResult(root).maxCount;
    }

    public static void main(String[] args) {
        // Create a binary tree (not shown here)
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);

        // Call the largestBst function and print the result
//        Node rootNode = buildTree();  // Replace with your method to build the tree
        int largestBstSize = largestBst(root);
        System.out.println("Size of the largest BST sub-tree: " + largestBstSize);
    }

    // Define the Node class (not provided in the original code)


    // Method to construct a sample tree (replace with your tree building logic)

}

