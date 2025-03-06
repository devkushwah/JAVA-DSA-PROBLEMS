package Stack.ConceptsAndMethods;

import java.util.Stack;

public class PreToPostConversion {
    public static void main(String[] args) {
        String str = "-9/*+5346";
        int n = str.length();
        Stack<String> st = new Stack<>();
        for (int i=n-1; i>=0; i--){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if (ascii>=48 && ascii<=57){
                st.push(ch+"");
            } else {
                String v1 = st.pop();
                String v2 = st.pop();
                char operatot = ch;
                //v1 v2 operator
                String operation = v1+v2+operatot;
                st.push(operation);

            }
        }
        System.out.println(st.peek());
    }
}

