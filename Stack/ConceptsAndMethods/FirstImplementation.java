package Stack.ConceptsAndMethods;
/* Java provides a direct method for printing the contents of a stack due to its built-in toString functionality, while C++ requires explicit iteration to achieve the same result. */

import java.util.Stack;

public class FirstImplementation {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
    }
}
