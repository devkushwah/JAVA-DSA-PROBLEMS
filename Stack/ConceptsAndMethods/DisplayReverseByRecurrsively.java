package Stack.ConceptsAndMethods;

import java.util.Stack;

public class DisplayReverseByRecurrsively {
    public static void reverseRecurrsively(Stack<Integer> st){
        if (st.empty()) return;
        int top = st.pop();
        System.out.print(top + " ");
        reverseRecurrsively(st);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        reverseRecurrsively(st);

    }
}
