package Tree.Traversal;
import java.util.HashMap;
import java.util.Map;

public class createTree {
    //create tree with help of inorder and preorder
    //iska concept simple video se hee samaz aa jaayga agar asie samaz nhi aa araha to

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            // ye humne mapping krdi inorder me index ke hisaab se
            inMap.put(inorder[i], i);
        }

        //ye hum tree structure me root node daal rahe hai uske liye
        TreeNode root = buildTree(preorder, 0, preorder.length - 1,
                                  inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd) return null;

        //ye humne preorder mese root node ki position dheki joki hum inorder me match krenge
        //aur [preStart isliye kyoki preOrder me preStart hee root node hota hai
        TreeNode root = new TreeNode(preorder[preStart]);

        //ab wo root position wala node hum inMap(inorder) me dhudhunge aur inMap(inorder) me uski position match
        // karne ke baad wo position....inRoot variable me daal denge...inRoot ka matlab hai inorder ka root
        int inRoot = inMap.get(root.val);

        // numsLeft = (value)index = 1 - 0
        int numsLeft = inRoot - inStart; // 1

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                              inorder, inStart, inRoot - 1, inMap);

        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                               inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = buildTree(preorder, inorder);

        // Additional code for result handling if needed
    }
}
