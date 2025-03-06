package LeetcodeProblems;
// Ye love babbar ke deletion prg jesa hai jo peele waale rajister me hai
public class DeleteMiddleNode {

        public static class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        public static Node deleteRightLL(Node head){     // This is for right middle
            Node slow = head;
            Node fast = head;

            if (head.next == null){    // yadi ek hee node ho to
                return null;
            }

            while (fast.next.next!= null && fast.next.next.next != null){   // even(middle right)  && odd
                slow  = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return head;
        }

        public static Node deleteLeftLL(Node head){
            Node slow = head;
            Node fast = head;

            while (fast.next.next!= null && fast.next.next.next.next != null){   // even(middle left) && odd
                slow  = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return head;
        }

        public static void display(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }

        public static void main(String[] args) {
            Node a = new Node(5);
//            Node b = new Node(3);
//            Node c = new Node(9);
//            Node d = new Node(8);
//            Node e = new Node(16);

//              a.next = b;
//              b.next = c;
//              c.next = d;
//              d.next = e;

            display(deleteRightLL(a));
            System.out.println();
           // display(deleteLeftLL(a));

        }

}
