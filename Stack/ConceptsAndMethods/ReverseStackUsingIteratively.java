package Stack.ConceptsAndMethods;
import java.util.Stack;
public class ReverseStackUsingIteratively {
//    #include<iostream>
//    #include<stack>
//    using namespace std;
//    int main(){
//        stack<int> st;
//
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        st.push(5);
//
//        while (!st.empty()) {
//            cout << st.top() << " ";
//            st.pop();
//        }
//        return 0;
//    }
    // ------------------------------------------METHOD-2-------------------------------------------------------
//    import java.util.Stack;
//
//    public class Main {
//        public static void main(String[] args) {
//            Stack<Integer> st = new Stack<>();
//
//            st.push(1);
//            st.push(2);
//            st.push(3);
//            st.push(4);
//            st.push(5);
//
//            while (!st.empty()) {
//                System.out.print(st.peek() + " ");
//                st.pop();
//            }
//        }
//    }
    //-------------------------------------------METHOD-3---------------------------------------------------------


    public static class display{
        public static void main(String[] args) {
            Stack<Integer> st = new Stack<>();

            st.push(1);
            st.push(2);
            st.push(3);
            st.push(4);
            st.push(5);

            for (int i = st.size() - 1; i >= 0; i--) {
                System.out.print(st.get(i) + " ");
            }
            System.out.println();
            for (int i = 0; i<st.size(); i++) {
                System.out.print(st.get(i)+ " ");
            }

        }
    }


}
