// Finding nth Node from last

package LeetcodeProblems;

public class FindNodeFromLast {
    public static Node findNode2(Node head, int n){
        // In  One traversal method
        Node fast = head;
        Node slow = head;

        for (int i = 1; i<=n; i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow  = slow.next;
        }
        return slow;
    }

    public static  Node findNode(Node head, int n){
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int m = size - n + 1;
        //mth Node from start
        temp = head;       // isme baapis temp ko haed isliye banaya kyoki while loop se wo null ban gaya tha

        for (int i = 1; i<=m-1; i++){
            temp = temp.next;
        }
        return temp;
    }
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(5);       //  a  isme object hai
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        // 5  3  9  8  16

        // (a.next) = address of b node hai... b ki value a node se connect ho gya
        a.next = b;   // 5->  3  9  8  16
        b.next = c;   // 5->  3->  9  8  16
        c.next = d;   // 5->  3->  9->  8  16
        d.next = e;   // 5->  3->  9->  8->  16

        Node find = findNode2(a, 4);    //Best method(rabbit - turtule problem)
        // Node find = findNode(a, 3);
        System.out.println(find.data);

    }
}
