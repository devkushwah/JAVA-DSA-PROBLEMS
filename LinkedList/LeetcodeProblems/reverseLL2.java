package LeetcodeProblems;

public class reverseLL2 {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static Node reversedLL2(Node head){
        if(head == null || head.next == null) return head;
        Node curr = head;
        Node prev = null;
        Node after = null;
        while (curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;

        }
        return prev;

    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        display(a);
        System.out.println();

        Node help = reversedLL2(a);
        display(help);

    }
}
