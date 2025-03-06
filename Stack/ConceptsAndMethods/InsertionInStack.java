package Stack.ConceptsAndMethods;
// Bich index me hee value insert karna
import java.util.*;
public class InsertionInStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);  // ye apn ne stack ko print karba dia
        int idx = 2;       // iss index pr daalna hai
        int x = 7;         // aur ye number daalna hai

        Stack<Integer> temp = new Stack<>();  // ye ek naya stack bana liya
        while (st.size()>idx){  // jab tak st stack idx=2 (third place) tak bach na jaay tab tak khaali karo
            //st stack ko khaaali karao aur temp me daalo(3 to 5)

            temp.push(st.pop());
        }

        st.push(x);  // ab st stack me sirf 2 hee jagah bachi hai idx=1,2(first & second)... to humne idx=2(
        // third position) par tum value= 7 daaldo ab st me 3 values(jagah hai)(1, 2, 3)

        while /*(temp.size()>0)*/ (!temp.empty()){ // ab uske aange ke temp stack dega
            st.push(temp.pop());
        }
        System.out.println(st);

    }
}
