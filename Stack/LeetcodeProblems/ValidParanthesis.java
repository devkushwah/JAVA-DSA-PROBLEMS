package Stack.LeetcodeProblems;

import java.util.*;

public class ValidParanthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // agar apan open bracket hai to seedhe push krdo stack me
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    // agar khaali hai to false krdo
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Paranthesis: ");
        String str = sc.nextLine();
        System.out.println(isValid(str));
    }
}
