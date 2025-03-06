package Tree;

public class ImplitationOfTree {

   public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

    }
    public static void display(Node root){
       if(root==null) return;
           System.out.print(root.val+"-> ");

       if(root.left != null) System.out.print(root.left.val+" ");

       if(root.right != null) System.out.print(root.right.val);
       System.out.println();

        display(root.left);
        display(root.right);
    }

    public static int size(Node root){
       if(root == null) return 0 ;
       return 1 + size(root.left) + size(root.right);
    }

    public static void preorder(Node root){
       if(root==null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static int max(Node root){
       if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    public static int sum(Node root){
       if(root==null) return 0;
       return root.val + sum(root.left) + sum(root.right);
    }

    public static int height(Node root){
       if(root==null || root.left==null && root.right==null ) return 0;
       return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int diameterOfBT(Node root){
       int[] diameter = new int[1];
       diameterHeight(root, diameter);
       return diameter[0];
    }

    public static int diameterHeight(Node root, int[] diameter){
       if (root == null){
           return 0;
       }

       int lh =diameterHeight(root.left, diameter);
       int rh = diameterHeight(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static boolean isBalanced(Node root){
       if (root == null){
           return false;
       }

       int leftHeight = height((root.left));
       int rightHeight = height(root.right);

       if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
           return true;
       }
       return false;
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

//        display(root);
//        System.out.println("Size of tree:  "+size(root));
//       // preorder(root);
//        System.out.println("Sum of tree: "+sum(root));
//        System.out.println("Mamximum of tree: "+ max(root));
//        System.out.println("height of tree: "+height(root));
        System.out.println(diameterOfBT(root));
   }
}
