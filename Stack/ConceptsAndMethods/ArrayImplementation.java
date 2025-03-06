package Stack.ConceptsAndMethods;

public class ArrayImplementation {
    public static  class  stack{
        final int[] arr = new int[5];
        private int idx = 0;
        void push(int x){
            if(isFull()){
                System.out.println("stack is full!! ");
                return;
            }
        arr[idx] = x;
        idx++;
        }

        int peek(){
            if(idx ==0 ){
                System.out.println("Empty stack!! ");
            return  404;
            }
            return arr[idx-1];
        }
        int pop(){
            if(idx==0){
                System.out.println("Stack is Empty!! ");
                return 404;
            }
            int pop = arr[idx-1];
            arr[idx-1] = 0;
            idx--;
            return pop;
        }
        void display(){
            for (int i = 0; i<=idx-1; i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }
        int size(){

            return idx;
        }

        boolean isEmpty(){
            if(idx==0) return  true;
            else return false;
        }
        boolean isFull(){
            if(idx == arr.length) return true;
            else return false;
        }

    }
    public static void main(String[] args) {
        stack st = new stack();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        st.push(5);
//
//        st.display();
//        st.pop();
//        st.display();
//        System.out.println(st.size());
//        st.push(6);
//        System.out.println(st.isFull());
//        st.push(7);
        System.out.println( st.peek());


    }
}
