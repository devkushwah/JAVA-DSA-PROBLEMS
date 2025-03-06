package LinkedList;

public class DoublyLL {
    public static class Node{
        int val;
        Node next;
        Node prev;

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
        System.out.println();
    }

    public static void displayRev(Node tail){
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.val  + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void display2(Node random){
        Node temp = random;
        while(temp != null) {
            System.out.print(temp.val  + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static Node insertHead(Node head, int x){
        Node t  = new Node(30);
        t.next = head;
        head.prev = t;
        head = t;
        return  head;
    }

    public static void insertTail(Node head, int x){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node t = new Node(x);
        temp.next = t;
        t.prev = temp;
    }

    public static void insertAtPosition(Node head, int idx, int x){

        Node r = head;
        for(int i = 1; i <= idx-1; i++){
            r = r.next;   // ye pehele waala hai
        }
        Node t = r.next;  // ye next or last waala hai
        Node s = new Node(x);   // ye beech waala hai
        // r s t
        r.next = s;
        s.prev = r;
        s.next = t;
        t.prev = s;

    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(6);
        Node c = new Node(13);
        Node d = new Node(2);
        Node e = new Node(8);

        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next  = null;


//        display(a);
//        displayRev(e);
//        display2(c);
//        Node newHead = insertHead(a,36 );
//        display(newHead);
         insertTail(a, 1000);
        display(a);
        insertAtPosition(a, 3, 786);
        display(a);
    }
}
