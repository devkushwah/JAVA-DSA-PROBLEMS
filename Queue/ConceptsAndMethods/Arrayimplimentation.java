package Queue.ConceptsAndMethods;

public class Arrayimplimentation {
    public static class queueA{
        private int f = -1;
        private int r = -1;
        int size = 0;
        int[] arr = new int [5];

        public void add(int val){
            if(r == arr.length) {
                System.out.println("Queue is full!! ");
                return;
            }
            if(f == -1) {  // if queue is currenty empty
                f = r = 0;
                arr[0] = val;
            }
            else{
                arr[++r]  =  val;
                size++;
                // arr[r+1] = int val;
                // r++;
            }
        }

        public int remove(){
            if(size == 0){
                System.out.print("Queue is empty!! " );
                return  404;
            }
            // int x = arr[f];
            // f++;
            // return x;
            f++;
            size--;
            return arr[f-1];
        }

        public int peek(){
            return arr[f];
        }

        public void display(){
            if(size == 0){
                System.out.println("Queue is empty!! ");
            }
            else{
                for(int i = f; i <= r; i++){
                    System.out.print(arr[i]+ " ");
                }
                System.out.println();
            }
        }






    }
    public static void main(String[] args) {
      queueA q = new queueA();
      q.display();
//      q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.display();
//        q.remove();
//        q.display();
//        q.remove();
//        q.display();
//        System.out.println(q.peek());
//        System.out.println("SIze of queue is: " + q.size);
    }
}
