package Tree;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BurnTree {
    public static Node markParent(Node root, Map<Node, Node> hm, int k) {
         /*
         * iss function me humne ek map lia hai aur ek target
         * Map:- ye mapping krke dega node ka uske parent nde se
         * target(k):- isme humne temp Node banaya hai wo humko target tak lekar jaayga...jisse humko target 'res' Node
         * milega ....aur....hum 'hm' Map me target aane tak sab map krdenge  aur 'res' target return krdenge*/

        Queue<Node> q = new LinkedList<>();
        Node res = root;
        q.add(root);
        // isme while loop me 'q' ki help me 'hm' Map me parent mapping ho gai target tak

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.data == k)
                res = temp;
            if (temp.left != null) {
                hm.put(temp.left, temp);
                q.add(temp.left);
            }
            if (temp.right != null) {
                hm.put(temp.right, temp);
                q.add(temp.right);
            }
        }
        return res;
    }

    public static int minTime(Node root, int target) {
        // LST aur RST ka to accses simple hai par parent ke liye ye 'hm' Map banaya hai
        Map<Node, Node> hm = new HashMap<>();
        // isme temp me target hai jiska acces humko  res se mila hai
        Node temp = markParent(root, hm, target);
        // isme pata chalege ki konsa node visited hai
        Map<Node, Boolean> vis = new HashMap<>();
        // Queue 'q' humko help krega curr Node ko pechan ne me dhklo niche curr kya krega
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        vis.put(temp, true);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            // flag isliye kyoki agar ek bhi node visit(Burn) hua to time to lgega hee...agar hum kisi node ko visit
            // krenge to hum ko flag ko false krdeneg agar ek bhi false mil gaya to time++ krna hai...isliye abhi
            // true hai par burn hone par false krdenge.
            boolean flag = true;
            for (int i = 1; i <= size; i++) {

                // curr node help krega ki current node visited hai ya nhi agar visited nhi hai to visit(Burn) kar denge
                Node curr = q.poll();
                // agar current node ka LST not null hai aur visited(Burn) bhi nhi hai to usko burn krenge aur usko q
                // me daalenge taaki uske bhi LST aur RST ko check kr sake...aur flag = false bhi karna hai taaki time++
                // kar sake
                if (curr.left != null && vis.get(curr.left) == null) {
                    q.add(curr.left);
                    vis.put(curr.left, true);
                    flag = false;
                }
                if (curr.right != null && vis.get(curr.right) == null) {
                    q.add(curr.right);
                    vis.put(curr.right, true);
                    flag = false;
                }

                // agar LST aur LST dono null hai ya visited hai to hum current node ka parent node check krenge joki
                // humko 'hm' Map me milega
                if (hm.get(curr) != null && vis.get(hm.get(curr)) == null) {
                    q.add(hm.get(curr));
                    vis.put(hm.get(curr), true);
                    flag = false;
                }
            }
            if (!flag)
                time++;
        }
        return time;
    }

    public static void main(String[] args) {
        // Create and setup the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Call the minTime method and print the result
        int target = 5; // Replace 5 with the desired target value
        int result = minTime(root, target);
        System.out.println("The minimum time to reach the target node is: " + result);
    }
}
