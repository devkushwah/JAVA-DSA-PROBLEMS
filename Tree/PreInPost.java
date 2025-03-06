package Tree;

public class PreInPost {

    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

    }
    public static int height(Node root){
       if(root==null || root.left==null && root.right==null ) return 0;
       return 1 + Math.max(height(root.left), height(root.right));
    }

        public static void preOrder(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");     // Root
        preOrder(root.left);                // left Node
        preOrder(root.right);               // right Node
    }

    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void nthLevelprint(Node root, int n){    // LEVEL ORDER TRAVERSAL(BFS)  HERE n IS LEVEL
        if(root==null) return;                             // BOHOT JADA GANDI T.C.
        if(n==1) System.out.print(root.val+" ");          // YE PREORDER TRAVERSAL HAI
        nthLevelprint(root.left, n-1);
        nthLevelprint(root.right, n-1);
    }


    public static void main(String[] args) {
        Node root = new Node(1);     // root Node
        Node a = new Node(2);       // ye Node bana diye
        Node b = new Node(3);
        root.left = a;                  // ye connect kar diye a aur b ko root node se
        root.right = b;

        Node c = new Node(4);
        Node d = new Node(100);
        a.left = c;
        a.right = d;

        Node e = new Node(6);
        Node f = new Node(7);
        b.left = e;
        b.right = f;
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);

        int level = height(root) + 1;
        for (int i = 1; i<=level; i++){   // YE SAARE LEVEL KE NODE KO PRINT KAR DEGA
            nthLevelprint(root, i);
            System.out.println();
        }

    }
}
