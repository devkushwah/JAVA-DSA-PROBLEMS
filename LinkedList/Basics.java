

public class Basics {

    public static void display(Node head){                 // Yha temp. Node dena jaruli tha isse dubara code chal sakta hai agar firse node banaao to
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static  void  displayRecurrsively(Node head){
        if(head == null) return;
        else{
            System.out.print(head.data + " ");
            displayRecurrsively(head.next);
        }
    }

    // Note: starting yha se hai

    public static class Node{           // Ye ek Node Class bana di
        int data;   // Value
        Node next;  // address of next node(ye agle ka address store karta hai)
        // value + address of next node = complete 1 node
        Node(int data){                // ye raha constructor Node naame ka joki integer value lega
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

        // Display a LinkedList !


        System.out.println(a.data);
        System.out.println(a.next.data);
        System.out.println(a.next.next.data);
        System.out.println(a.next.next.next.data);
        System.out.println(a.next.next.next.next.data);


       Node temp = a;                  // naya temp Node nahi bana hai
//        for(int i = 1; i<=5; i++){
//            System.out.println(temp.data+" ");
//            temp = temp.next;
//        }

        while (temp != null){
            System.out.println(temp.data+" ");
           temp = temp.next;

        }

        // Temperaroty Node banana padhta(jaruli)  hai warna nhi bnaaoge to tail tak rukk jaane ke baad koi dusra loop ya code nhi chalega
        // ek hee baaar chalke reh jaayga
//
        display(a);
        System.out.println();             // Using function
        display(a);

        displayRecurrsively(a);              // Using Recurrsion(Recurrsively)
    }
}
