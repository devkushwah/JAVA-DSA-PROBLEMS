package Stack.ConceptsAndMethods;

public class LLStackImplimetation {
    public static class Node{   // user defind data type
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }

    }

    public static class LLstack{  // user defind data structure
        Node head = null;
        int size = 0;
        void puss(int x){

            Node temp  = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }

        int pop(){
            if(head == null){
                System.out.println("Stack is Empty");
                return 404;
            }
            int x = head.val;
            head = head.next;
            size--;
            return  x;
        }

        int peek(){
            return head.val;
        }
        void displayRecuresively(Node h){
            if(h == null) return;
            displayRecuresively(h.next);
            System.out.print(h.val+ " ");
        }
        void display(){
            displayRecuresively( head);
            System.out.println();
        }
        void displayReverse(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.val+ " ");
                temp = temp.next;
            }
            System.out.println();
        }
        int size(){
            return  size;
        }
    }
    public static void main(String[] args) {
        LLstack st = new LLstack();
        st.puss(1);
        st.puss(2);
        st.puss(3);
        st.puss(4);
        st.puss(5);

        st.display();
        st.pop();
        st.display();
        System.out.println(st.size());
    }
}
