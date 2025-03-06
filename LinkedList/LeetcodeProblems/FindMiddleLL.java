package LeetcodeProblems;

public class FindMiddleLL {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static Node middleRightLL(Node head){     // This is for right middle
        Node slow = head;
        Node fast = head;

        while (fast!= null && fast.next != null){   // even(right)  &&  odd
            slow  = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node middleLeftLL(Node head){
        Node slow = head;
        Node fast = head;

        while (fast.next!= null && fast.next.next != null){
            slow  = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        Node f = new Node(18);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(middleLeftLL(a).val);   // This for left Middle
        System.out.println(middleRightLL(a).val);  // This is for right Middle


    }
}
