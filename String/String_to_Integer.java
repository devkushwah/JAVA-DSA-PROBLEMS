package String;

public class String_to_Integer {
    public static int myAtoi(String s) {
        // ye whitespace se trim krne ke liye
        s = s.trim();

        // If the string is empty, return 0
        if (s.length() == 0) {
            return 0;
        }

        boolean neg = false; // To track if the number is negative
        int ans = 0; // Result
        int i = 0; // Index pointer

        // pehle hum first character ka sign kar karenge
        char firstChar = s.charAt(i);

        if (firstChar == '-') {
            neg = true;
            i++; // Move to the next character, rokenge nahi
        } else if (firstChar == '+') {
            i++; // Move to the next character, rokenge nahi
        }

        // Process digits
        while (i < s.length()) {
            char ch = s.charAt(i);

            // Break if non-digit character is encountered
            // agar digit mila to hee aange bhadenge nahi to yahi ruk jaaynge
            if (ch < '0' || ch > '9') {
                break;
            }

            // yaha par ASCII value ki help se char to int kar rahe hai
            int digit = ch - '0';

            // Check for overflow or underflow
            // bhai data ki kuch min/max limit hoti hai
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // konsi digit kaha aani hai uske liye
            ans = ans * 10 + digit;
            i++;
        }

        // yaha decide hoga ki sign lagana hai ya nahi
        return neg ? -ans : ans;
    }

    public static void main(String[] args) {


        // Test cases
        String[] testCases = {
                "42",
                "   -42",
                "4193 with words",
                "words and 987",
                "-91283472332",
                "91283472332",
                "+123",
                "",
                "   +0 123",
                "000001234"
        };

        for (String testCase : testCases) {
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Output: " + myAtoi(testCase));
            System.out.println("--------------------------");
        }
    }
}
