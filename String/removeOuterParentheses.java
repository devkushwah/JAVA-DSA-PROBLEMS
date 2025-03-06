package String;

public class removeOuterParentheses {
    public static String removeOuterParentheses(String s) {

        //humne ek stringBuilder bana liya
        StringBuilder sb = new StringBuilder();
        int openCount = 0;  // This will track the balance of open parentheses

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (openCount > 0) {  // Skip the outermost '('
                    sb.append(ch);
                }
                openCount++;
            } else {
                openCount--;
                if (openCount > 0) {  // Skip the outermost ')'
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {


        String input = "(()())(())";  // Example input
        String result = removeOuterParentheses(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }
}
