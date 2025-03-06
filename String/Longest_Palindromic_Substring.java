package String;
import java.util.Scanner;




public class Longest_Palindromic_Substring {

    //YT ki approach nikhil lohia
    public static String longestPalindrome1(String s) {
        if (s.length() <= 1) return s; // If the string is empty or has one character, return it.
        String LPS = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes centered at `i`
            int low = i, high = i;

            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                String palindrome = s.substring(low, high + 1);
                if (palindrome.length() > LPS.length()) {
                    LPS = palindrome;
                }
                low--;
                high++;
            }

            // Even-length palindromes centered between `i` and `i+1`
            low = i;
            high = i + 1;

            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                String palindrome = s.substring(low, high + 1);
                if (palindrome.length() > LPS.length()) {
                    LPS = palindrome;
                }
                low--;
                high++;
            }
        }

        return LPS;
    }

// Approach 1: Brute Force
    public static String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

// Approach 2: Expand Around Center
    public static String longestPalindrome3(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }
    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

// Approach 3: Dynamic Programming
    public static String longestPalindrome4(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

//    Approach 4: Manacher's Algorithm
    public static String longestPalindrome5(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);
        s = "#" + s.replaceAll("", "#") + "#";
        int[] dp = new int[s.length()];
        int center = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length() && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxStr = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
            }
        }

        return maxStr;
    }

//    Approach 5: Recursive TLE(Time Limit Exceeded)

    public static String longestPalindrome6(String s) {
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return s;
        }

        String left = longestPalindrome6(s.substring(1));
        String right = longestPalindrome6(s.substring(0, s.length() - 1));

        if (left.length() > right.length()) {
            return left;
        } else {
            return right;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to find its longest palindromic substring:");
        String input = scanner.nextLine();


//        String result = longestPalindrome1(input);
//        String result = longestPalindrome2(input);
//          String result = longestPalindrome3(input);
//          String result = longestPalindrome4(input);
//          String result = longestPalindrome5(input);
          String result = longestPalindrome6(input);

        System.out.println("The longest palindromic substring is: " + result);

        scanner.close();
    }
}
