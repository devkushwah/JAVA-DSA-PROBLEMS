package Stack.ConceptsAndMethods;
// by pepcoding
import java.util.Stack;

public class InfixEvalutionBySumitSir {
    public static void main(String[] args) {

        Stack<Integer> oprnds = new Stack<>(); // ye operands ka stack bana lia
        Stack<Character> oprtor = new Stack<>();  // ye operator ka stack bana lia
        String str = "9-(5+3)*4/6";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 4 hee condition hogi= 1.'(', 2.any digit, 3.')', 4.any operator

            if (ch == '(') oprtor.push(ch);   // fisrt:- agar open bracket to operator ke stack me daaldo
            else if (Character.isDigit(ch)) {   // ye check karne ke liye ki val operator hai ya oprands lekin apn
                // caharcters le rahe hai isliye...
                oprnds.push(ch - '0');   // ye minus kar rahe hai ye ek method hai chat ki ascii value se digit banane ki
            }

            else if (ch == ')') {     //  agar close brackets baadme aaya to  tumko pata hai pop() karana hai aur unn
                //  bich ke operators ko operands se calculate karte rhna hai
                while (!oprtor.isEmpty() && oprtor.peek() != '(') {  // (Size 0 hone tak pop hoga && tab tak pop()
                    // karana hai jab tak '(' se ')' naa aa jaay kyoki inke bich hee to pop karate hai)

                    char oper = oprtor.pop(); // jo peek pr hoga wo operation perform krega operand stack me jaayga
                    int v2 = oprnds.pop();  // jo operands stack ke peek par honge unko v1 aur v2 bnaaynge
                    int v1 = oprnds.pop();

                    int opv = operation(v1, v2, oper);  // opv calculate krke operands ke peek pr wo calculate ki hui
                    // value daaldega
                    oprnds.push(opv);
                }
                oprtor.pop(); // ab oparator ke stack me jo '(' dala hai usko to hata na pdega na taaki neeche ke bhi
                // oprator participate sake
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {  // ya to operators honge
                while (oprtor.size() > 0 && oprtor.peek() != '(' && precedence(ch) <= precedence(oprtor.peek())) {
                // (size 0 hone tak pop hoga && pop ho raha hai to open bracket tak hee hoga unke bich && tab tak pop
                    // hoha jab tak peek par bdi pririty ka hoga

                    char oper = oprtor.pop();   // same as previous explaination
                    int v2 = oprnds.pop();
                    int v1 = oprnds.pop();

                    int opv = operation(v1, v2, oper);  //operation hoga teeno me
                    oprnds.push(opv); // oprands ke stack me peek pr daalega
                }
                oprtor.push(ch);    // agar koi operation nhi ho raha priority ki wjh se to sirf push krdo...agar
                // doubt hai to dry run krke dhko
            }
        }
        while (!oprtor.isEmpty()) {
            char oper = oprtor.pop();
            int v2 = oprnds.pop();
            int v1 = oprnds.pop();

            int opv = operation(v1, v2, oper);  // operation hoga teeno me jab tak stack khaali naa ho jaay
            oprnds.push(opv);  // oprands ke stack me peek pr daalega
        }
        System.out.println(oprnds.peek());  // Final Answer
    }

    public static int precedence(char oper) {
        if (oper == '+' || oper == '-') return 1;
        else if (oper == '*' || oper == '/') return 2;
        else return 0; // Default precedence for other characters
    }

    public static int operation(int v1, int v2, char oper) {
        if (oper == '+') return v1 + v2;
        else if (oper == '-') return v1 - v2;
        else if (oper == '*') return v1 * v2;
        else return v1 / v2; // Note: Assuming division is valid and v2 is not 0
    }
}
