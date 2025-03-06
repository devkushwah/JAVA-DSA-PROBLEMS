package String;

public class largest_odd_number {
    public static String largestOddNumber(String num) {
        int n = num.length();

        for (int i = n - 1; i >= 0; i--) {
            // Check if the character at index `i` is an odd digit
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);  // Get the substring from 0 to i+1
            }
        }
        return "";  // Return an empty string if no odd digit is found
    }

    public static void main(String[] args) {

        String num = "1258";  // Test example, you can change this for other tests
        System.out.println("Largest odd number: " + largestOddNumber(num));
    }
}
