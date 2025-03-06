public class ValidPalindrome {

    //Iteratively
        public boolean isPalindromeIteratively(String s) {
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove non-alphanumeric characters and convert to lowercase
            int high = s.length() - 1; // Corrected syntax to use length() instead of length
            int low = 0;
            while (low <= high) { // Corrected the loop condition
                if (s.charAt(low) != s.charAt(high)) return false; // Used charAt() to access characters in the string
                low++;
                high--;
            }
            return true;
        }

    // Recursively

    public static boolean isPalindromeRecurr(String s) {
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove non-alphanumeric characters and convert to lowercase
            return checkPalindrome(s, 0, s.length() - 1);
        }

        private static boolean checkPalindrome(String s, int low, int high) {
            if (low >= high) {
                return true;  // Base case: the string is a palindrome
            }
            else if (s.charAt(low) != s.charAt(high)) {
                return false;  // Base case: characters at low and high index do not match
            }
            else {
                return checkPalindrome(s, low + 1, high - 1);  // Recur with updated low and high indices
            }
        }

        public static void main(String[] args) {
            String test1 = "A man, a plan, a canal, Panama";
            String test2 = "race a car";

            System.out.println(isPalindromeRecurr(test1)); // Output: true
            System.out.println(isPalindromeRecurr(test2)); // Output: false
        }
    }


