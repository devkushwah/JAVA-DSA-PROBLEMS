package DoublyLL;

public class implementation {
    public static class Node {
        Node prev;
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

    public static void displayRev(Node tail) {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
    }
    public static Node insertAtHead( Node head, int val){
        Node temp = new Node(val);
        temp.next = head;
        head.prev = temp;
        head = temp;
        return head;
    }
    public static void insertAtTail(Node head, int val){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node t = new Node(val);
        temp.next = t;
        t.prev = temp;

    }
    public static void insertAtPosition(Node head, int idx, int x){
        Node prevNode = head;
        for(int i = 1; i <= idx-1; i++){
            prevNode = prevNode.next;   // ye pehele waala hai
        }

        Node nextNode = prevNode.next;  // ye next or last waala hai
        Node currNode = new Node(x);   // ye beech waala hai
        // r s t
        prevNode.next = currNode;
        currNode.prev = prevNode;
        currNode.next = nextNode;
        nextNode.prev = currNode;

    }
   public static Node deleteAtHead(Node head){
        Node temp = head;
        head = head.next;
        head.prev = null;
        return  head;

    }
    public static void deleteAtTail(Node head){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp = temp.prev;
        temp.next =null;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);

        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = null;

        display(a);
        System.out.println();
        displayRev(e);
        System.out.println();
       Node newNode = insertAtHead(a, 10);
       display(newNode);
        System.out.println();
//        insertAtTail(a, 60);
//        display(a);
       insertAtHead(a, 55);
        display(a);
        System.out.println();
        insertAtPosition(a, 2, 70);
        display(a);
        System.out.println();
        deleteAtTail(a);
       Node t1 =  deleteAtHead(a);
        display(t1);



    }

}
