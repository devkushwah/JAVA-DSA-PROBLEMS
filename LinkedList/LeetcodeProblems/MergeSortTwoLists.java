// In assending order
package LeetcodeProblems;

public class MergeSortTwoLists {



        public static class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        public static Node MergeSortList(Node head1, Node head2){
            Node temp1 = head1;
            Node temp2 = head2;
            Node head = new Node(100);
            Node temp = head;  // temp me 100 dala hai

            while (temp1 != null && temp2 != null){  // jab tak dono null nahi ho jaate tab tak chalate rehna hai
            if(temp1.val < temp2.val){
                Node a = new Node(temp1.val);  // ek naya Node banaya jisme chhoti value jaaygi
                temp.next = a;    //  temp ko 'a' se attached kardiya    [(temp,head)100 -> (a)1]
                temp = a;    //  temp ko 'a' ke badle rakhdiya uski jagaha dedi  [(head)100 -> (temp)1 -> (a)2 -> ......... ]
                temp1 = temp1.next;  // agar temp1 chhota hai to uski value dekar aange pochaao
            }
            else {
                Node a = new Node(temp2.val);
                temp.next = a;
                temp = a;
                temp2 = temp2.next;
            }
            }

            if(temp1 == null) temp.next = temp2;  // agar temp1 null ho gya to temp ko temp2 se attached kardo
            else temp.next = temp1;               // nahi to temp ko temp1 se attached kardo
            return head.next;                     // head.next isliye kyoki 100 nahi apnko
        }

        public static void display(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }

        public static void main(String[] args) {
          Node head1 = new Node(1);
          head1.next = new Node(3);
          head1.next.next = new Node(5);
          head1.next.next.next = new Node(8);
          head1.next.next.next.next = new Node(9);

            Node head2 = new Node(2);
            head2.next = new Node(4);
            head2.next.next = new Node(6);
            head2.next.next.next = new Node(7);
            // 1 3 5 8 9   2 4 7
          Node merged =   MergeSortList(head1, head2);
          display(merged);

        }

    }


