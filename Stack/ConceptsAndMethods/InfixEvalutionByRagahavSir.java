package Stack.ConceptsAndMethods;
// by Raghav sir
import java.util.Stack;

public class InfixEvalutionByRagahavSir {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        Stack<Integer> val = new Stack<>();  // operands
        Stack<Character> op = new Stack<>(); // operator

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;

            if (ascii>=48 && ascii<=57)   // 1. ya to char digit hai(0 to 9)
                val.push(ascii-48);   // to push krdo ye ek method hai char se digit me convert karne ki

            else if (op.isEmpty() || ch=='(' || op.peek()=='(') {  // 2. ya to character open bracket hai to push krdo
                op.push(ch);

            } else if (ch==')') {  //3. ya to char close bracket hai....agar close bracket aa gya to tumko pta hai  wo
                // open bracket ke baad hee aaya hoga... isliye dono ke bich pop karate raho raho tab tak jab open
                // bracket naa aajaay
                while (op.peek()!='('){
                    // work

                    // ye dono oprators stack ke peeks value hai
                    int v2 = val.pop();
                    int v1 = val.pop();
                    // ye saare operations hai ki konse operator par konsa operation hona hai
                    if (op.peek()=='+') val.push(v1+v2);
                    if (op.peek()=='-') val.push(v1-v2);
                    if (op.peek()=='*') val.push(v1*v2);
                    if (op.peek()=='/') val.push(v1/v2);
                    op.pop();  // kaam karne ke baad operator pop krdo ek ek krke
                }
                    op.pop();  // aakhir me open bracket '(' bhi hata do... while condition aur logic ke hisaab se
            } else {
                if (ch=='+' || ch=='-'){  // 4. ye chhoti priority waalo ke liye agar character yeh ho to
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek()=='+') val.push(v1+v2);
                    if (op.peek()=='-') val.push(v1-v2);
                    if (op.peek()=='*') val.push(v1*v2);
                    if (op.peek()=='/') val.push(v1/v2);
                    op.pop();  // kaam karne ke baad operator pop krdo ek ek krke
                    // push
                    op.push(ch);   // v1 aur v2 ke bich operation hone ke baad uss value ko oprands ke stack me peek
                    // pr daaldo

                }
                if (ch=='*' || ch=='/'){  // same as lower proirity characters

                    if (op.peek()=='*' || op.peek()=='/'){
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek()=='*') val.push(v1*v2);
                        if (op.peek()=='/') val.push(v1/v2);
                        op.pop();
                        // push
                        op.push(ch);
                    }
                    else op.push(ch);   // agar '* aur /' peek par par nhi hai to unko sirf push krdo..  agar koi
                    // operation nhi ho raha priority ki wjh se to sirf push krdo...agar doubt hai to dry run krke dhko
                }


            }
        }
        // aakhir me sab kuch khatam ho jaayga sab brackets, priority operators....jo bachenge stack me unhee me
        // operations krwa do ek ek krke
        while (val.size()>1){
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek()=='+') val.push(v1+v2);
            if (op.peek()=='-') val.push(v1-v2);
            if (op.peek()=='*') val.push(v1*v2);
            if (op.peek()=='/') val.push(v1/v2);
            op.pop();
        }
        System.out.println(val.peek());

    }
}
