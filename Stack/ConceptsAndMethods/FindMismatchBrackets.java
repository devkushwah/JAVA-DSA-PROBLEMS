package Stack.ConceptsAndMethods;
import java.util.*;
//ye unn brackets ko nikaalta hai joki galat hai
public class FindMismatchBrackets {
    public static List<Character> findMismatchedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        List<Character> mismatchedBrackets = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // iss cheez ka taatparya hai ki....check karo ki stack khaali to nahi hai usme konsa bracket hai..
                // .agar usme open['('] hua to apna close[')'] aake usko pop krdega fir stack khaali koi mismatch nahi
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    // agar stack khaali hai. aur ch==')' ko point kar raha hai...to hum usko mismatchedbrackets me
                    // list ke dwara add krdenge
                } else {
                    mismatchedBrackets.add(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            // dhko upr to close bracket ka hisab ban gya ab ye open bracket ka hisab bnaayga
            // concept: agr close bracket nhi honge to stack me sirf open bracket hee bachenge...to seedhi baat ye
            // hai ki jab tak stack khaali na jaay tab tak unn open brackets ko  mismatc me add katate jaao
            mismatchedBrackets.add(stack.pop());
        }

        return mismatchedBrackets;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Brackets: ");
        String str = sc.nextLine();
        List<Character> mismatched = findMismatchedBrackets(str);

        if (mismatched.isEmpty()) {
            System.out.println("The sequence is balanced.");
        } else {
            System.out.println("Mismatched brackets: " + mismatched);
        }
    }
}
