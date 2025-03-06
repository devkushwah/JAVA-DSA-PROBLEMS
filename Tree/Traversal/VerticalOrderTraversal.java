package Tree.Traversal;
import java.util.*;

/**
 * Definition for a binary tree node.
 */
class Node {
    int val;
    Node left;
    Node right;
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple {
    Node node;
    int row;
    int col;

    public Tuple(Node _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

class VerticalorderTraversal {
    public static List<List<Integer>> verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        //Humne map bana dia { verticle, (level, nodes) }
        Queue<Tuple> q = new LinkedList<>();
        // queue humne traversal ke liye banaya hai
        //ye humne queue bna dia jisme hum khela khelenge...Aur ye TUPLE type ka hai
        //Tuple  = { nodes, (verticle, level) }
        q.offer(new Tuple(root, 0, 0));
        // humne queue me root node daal dia verticle aur level ke sath

        while (!q.isEmpty()) {
            // jab tak queue khaali na ho jaay tab tak chalana hai
            Tuple tuple = q.poll();
            // Abhi Tuple matlb Queue hee hai jisme 3 values ka {key, value} ha...aur humne tuple me se front root ko
            // pop krdo aur tuple naam ke node me store krdo
            Node node = tuple.node;
            // tuple.node ka matlb hai tuple node jo humne poll() kia tha usme  me 3 values haii { node, row(vertcal),
            // col(level) } to hum tuple.node krke teeno mese sirf node ko access kar rahe hai..aur node naam ke node
            // me daal rahe hai.....iska mtlb hai node = root node hai

            int x = tuple.row;  //ye humne vertcle nikaal liya root node ka
            int y = tuple.col;  //ye humne level nikaal liya root node ka

            // Process left child: agar map me x key lie nhi krti to map ke TreeMap<Integer> me  x key put  krdo
            if (!map.containsKey(x)) {   //x = (Verticle) =>  { x, (y, nodes) } => { verticle, (level, nodes) }
                map.put(x, new TreeMap<>());
            }

            // Process right child : agar map x me y key lie nhi krti to x me PriorityQueue<Integer> me  y key put krdo
            if (!map.get(x).containsKey(y)) { //y = (levels) => {x, (y, nodes)} => { verticle, (level, nodes) }
                map.get(x).put(y, new PriorityQueue<>());
            }
            // x ko get() karo usme y ko get() kro aur usme nodes.val add kardo
            map.get(x).get(y).offer(node.val);

            if (node.left !=  null) {
                //  agar node ka LST != null hai to usko queue ke tuple me daaldo.
                // aur uska verticle aur level bhi daaldo changes karke jo parent node ka vertcle, level tha uske
                // hisab se
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right !=  null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        // At the last put kr krke map me TreeMap<Integer> aur PriorityQueue<Integer> bhar chuka hoga ab hum list
        // bnaaynge aur usme sab daalenge

        List<List<Integer>> list = new ArrayList<>();   // ye humne list of lists bna dia nodes store ke liye

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {  // Humne for-each loop chalaya jisme ys
            // naam ki list bna dia joki TreeMap<> type  hai jisme {y, (nodes)} or {level, (nodes)} values hai
            //aur map.values ka mtlb hai TreeMap<> yaani sirf {y, (nodes)} or {level, (nodes)} ko iterate karana
            // hai isme hee sab iteration hoga

            list.add(new ArrayList<>());  // ys jitni baar iterarte krega utni baar list banegi
            for (PriorityQueue<Integer> nodes : ys.values()) {  //PriorityQueue<Integer> = nodes and ys.values() = nodes
                // ab humne nodes naam ki list bna dia joki ys.Values() yaani saare nodes ko access krega
                //
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                    // isme list.size() - 1 = inner lists ko denote kar raha hai jisme hum ek ek krke nodes daal rahe
                    // hai....agar confusion hai to for loop count karo...ki kis prakaar list ban rhi hai
                }
            }
        }
        return list;
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

        VerticalorderTraversal solution = new VerticalorderTraversal();

        // Get the Vertical traversal
        List<List<Integer>> verticalTraversal = VerticalorderTraversal.verticalTraversal(root);

        // Print the result
        System.out.print("Vertical Traversal: ");
        for (List<Integer> level : verticalTraversal) {
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
