package Stack.ConceptsAndMethods;
// ek stack ko copy krke dusra stack banana
import java.util.Stack;

public class CopyStack {
    public static void main(String[] args) {
        Stack <Integer> st = new Stack<Integer>();   // ye banaya ek stack st naam ka
        st.push(10);   //  usme values daaldi
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);  // ye usko print bhi kara dia

        //Reverse order
        Stack<Integer> gt = new Stack<>();   // ye ek naya dusra stack bana dia gta naam ka
        while(st.size()>0){   // (!st.empty())...jab tak stack khaalu nhi hota
            gt.push(st.pop()); // tab takk gt me push karte raho
        }
        System.out.println(gt);  // gt ko bhi print karado(Ab ye st ka reverse ban gata "odd + odd = even" type

        // reverse Of reverse
        Stack<Integer> rt = new Stack<>();  // ye ek aur naya stack bana diyya rt naam ka
        while(gt.size()>0){     // jab tak gt khaali na ho jaay tab tak rt me push karte raho
            rt.push(gt.pop());
        }

        System.out.println(rt); // copy ho gya reverse of reverse krke

    }
}
