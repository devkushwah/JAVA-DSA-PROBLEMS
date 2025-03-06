// Delete nth Node from last and tum sirf isme aakhri waale ki value daal rahe ho usko delete nahi kar rahe ho isse wo gayab ho jaayga par memory me rahega
// Leetcode 237

package LeetcodeProblems;

public class DeleteNodeFromLast {
    public static class Node {
        int data;
        Node next;
        Node(int data){
        this.data = data;
        }
    }
    public static Node nthNodeDelete(Node head, int n){
        Node fast = head;
        Node slow = head;

        for (int i = 1; i<=n; i++){
            fast = fast.next;
        }
        if (fast == null){      // bhai agar idex == size doge wo bhi last se mtlb fir wo to head hee huya na
            head = head.next;
            return  head;
        }
         while (fast.next != null){
             fast = fast.next;
             slow = slow.next;
         }
         slow.next = slow.next.next;
         return head;

    }
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node a  = new Node(9);
        Node b  = new Node(6);
        Node c  = new Node(4);
        Node d  = new Node(44);
        Node e  = new Node(88);
        Node f  = new Node(96);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        display(a);
        a = nthNodeDelete(a, 6);
        display(a);

    }
}
