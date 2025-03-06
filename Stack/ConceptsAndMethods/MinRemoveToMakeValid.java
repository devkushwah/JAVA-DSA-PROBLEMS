package Stack.ConceptsAndMethods;
import java.util.Scanner;
import java.util.Stack;
// ye sab batata hai ki kitne brackets galat hai
public class MinRemoveToMakeValid {
    public static int minRemoveToMakeValid(String s) {
        int count = 0; // counter to keep track of removed brackets
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // if you don't understand check balancedBracket code file
                if (stack.isEmpty() || stack.peek() != '(') {
                    // count++ isliye kyoki stack khaali hai to akela close bracket kya karega || agar stack khaali
                    // nahi hai aur usme open bracket nhi hai to iska mtlb usme close bracket hai..upr se ek aur
                    // close bracket aa raha hai to  dono conflict krdenge...so count++
                    count++;
                }
                else {
                    // agar stack khaali nhi hai usme open bracket hai to apna close bracket aakr pop krdega to stack
                    // khaali ho jaayga fir koi count++ ji jrurt nhi
                    stack.pop();
                }
            }
        }

        // agar stack me open bracket huye to stack me honge uske size se pata chal jaayga ki itne open brackets
        // galat hai.....agar close brackets galat huye to count se pata chal jaayga
        count = count +  stack.size();

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Paranthesis: ");
        String str = sc.nextLine();
        System.out.println( minRemoveToMakeValid(str));
    }
}
