package Queue.ConceptsAndMethods;

public class CircularQueueArray {
    public static class cqa{
        int front = -1;
        int rear = -1;
        int size = 0;
        int[] arr = new int[5];

        public void add(int val) throws Exception{
        if(size == arr.length){
        throw new Exception("Queue is Full!! ");
        }

        else if (size == 0) {
        front = rear =0;
        arr[0] = val;
        }
        else if (rear < arr.length-1) {
        arr[++rear] = val;
        }
        else if (rear == arr.length-1 ) {
        rear = 0;
        arr[0] = val;
        }
        size++;
        }

        public int remove() throws Exception{
            if(size == 0){
                throw new Exception("Queue is Empty!! ");
            }
            else {
                int val = arr[front];
                if(front == arr.length-1) front = 0;
                else front++;
                size--;
                return val;
            }
        }

        public int peek() throws Exception{
            if(size == 0){
                throw new Exception("Queue is Empty!! ");
            }
            return arr[front];
        }

        public void display() throws Exception{
            if(size == 0){
                throw new Exception("Queue is Empty!! ");
            }
            else if(front<=rear){
                for (int i = front; i<=rear; i++){
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            else{ // front > rear
                for (int i = front; i<arr.length;i++){
                    System.out.print(arr[i]+" ");
                }
                for (int i = 0; i<=rear; i++){
                    System.out.println(arr[i]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        cqa q = new cqa();

      q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.display();  // 1 2 3 4 5
        q.remove();
        q.display();  // 2 3 4 5
        q.add(6);
        q.display();  // 6 2 3 4 5     =>      2 3 4 5 6
        System.out.println(q.peek());
        System.out.println("SIze of queue is: " + q.size);
        for (int i =0; i<q.arr.length; i++){
            System.out.print(q.arr[i] + " ");
        }
    }
}
