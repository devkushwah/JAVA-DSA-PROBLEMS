
public class implementation {

    public static class Node {
        int data;
        Node next;
//
//        Node(int data) {
//            this.data = data;
//        }
Node(int data) {
    this.data = data;
    this.next = null;     // ye dena wese jaruli nahi hai kyoki by default hee hota hai
}
    }

    public static class linkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtEnd(int val) {
            Node temp = new Node(val);

            if (head == null) {
                head = temp;
//                tail = temp;

            } else {
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        void insertAtHead(int val) {
            Node temp = new Node(val);       // temp. object creation with taking value

            if (head == null) {     // empty list
                head = tail = temp;
                // insertAtEnd(val);

            } else {                // non-empty
                temp.next = head;
                head = temp;
            }
            size++;


        }

        void insertAt(int idx, int val) {
            Node newNode = new Node(val);
            Node temp = head;                   // public static hai na isliye iss scope me chal rha hai with value

            //  jo index tum doge ye uske baad assign hoga
            if (idx == size) {
                insertAtEnd(val);
            } else if (idx == 0) {
                insertAtHead(val);
            } else if (idx < 0 || idx > size) {
                System.out.println("Wrong index!!");

            }
//            // main kaam( Taking 1 Pointer only)
//            for (int i = 1; i <= idx - 1; i++) {   // 1 to idx-1 isliye kyoki (0 aur idx tum de chuke wo wo head aur tail hai)
//                temp = temp.next;    // ek node pehle le aay
//            }
//            t.next = temp.next;
//            temp.next = t;
//            size++;
//        }

            // main kaam(Taking 2 Pointers)
            for (int i = 1; i <= idx - 1; i++) {   // 1 to idx-1 isliye kyoki (0 aur idx tum de chuke wo wo head aur tail hai)
                temp = temp.next;    // ye prev Node hai
            }
            Node curr = temp.next;  // ye newNode ke baad waala curr Node hai
            newNode.next = curr;    // first aise = / and then \
            temp.next = newNode;
            size++;
        }

        int getAt(int idx) {
            if (idx > size || idx < 0) {
                System.out.println("Wrong index!!");
                return 404;
            }
            Node temp = head;
            for (int i = 1; i <= idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

//        void deleteAt(int idx) {
//            Node temp = head;
//            if (idx==0) {
//                head = head.next;    // this is for head
//            }
//            else {
//
//                for (int i = 1; i<=idx-1; i++){
//                    temp = temp.next;
//                }
//                temp.next = temp.next.next;   // this is for specific position
                // temp.next.next = null; (kyoki delete waala node usse abhi bhi juda tha neche)
//                if (idx==size-1) tail = temp;   // this is for tail
//            }
//            size--;
//        }


        // Best method of deletion by love Babbar sir(Kyoki isme wo faaltu node ko delete kardete hai)
        void deleteAt(int idx) {
            if (idx < 0 || idx >= size) {
                // Handle index out of bounds error
                System.out.println("Wrong index!!");
            }

            if (idx == 0) {
                // Deleting the head node
                head = head.next;
                if (head == null) {
                    // If the list becomes empty after deletion, update the tail as well
                    tail = null;    // bhailog head ki pechan hai agr koi node nahi hoga to tail kise maane
                }
            } else {
                Node prev = head;
                for (int i = 0; i < idx - 1; i++) {
                    prev = prev.next;
                }
                prev.next = prev.next.next;   // this is for specific position
                if (idx == size - 1) {
                    // If the deleted node is the tail, update the tail to the previous node
                    tail = prev;   // this is for tail
                }
            }

            size--;
        }


        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        int size() {                     // ye jitne baar size ginega utni baar loop chalega isliye iski time complexity O(n) ho jaaygi aur sp- c = O(1)
//                Node temp = head;      // isliye hum sirf size++ karke kaam kar sakte hai time comp = O(1) ho jaaygi
//                int count = 0;
//                while (temp != null) {
//                    count++;
//                    temp = temp.next;
//                }
//                return count;
//            }

            return size;

        }
      }
      
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtEnd(5);     // 5     (Ye manually karne se to acha hai)
        ll.display();

        ll.insertAtEnd(6);    // 5 -> 6
      //  ll.display();

//        System.out.println(ll.size());

        ll.insertAtEnd(12);   // 5 -> 6 -> 12
     //   ll.display();

        ll.insertAtHead(555);   // 555 -> 5 -> 6 -> 12
        ll.display();

        ll.insertAt(3 , 115);
        ll.display();

       // System.out.println(ll.getAt(3));
        ll.deleteAt(0);
        ll.display();
        System.out.println("Size of linkedlist: " + ll.size());
        System.out.println("Tail is: " + ll.tail.data);
     //   System.out.println("Reversed linked list:");
//        ll.reverseDI();
//        ll.display();

    }
}