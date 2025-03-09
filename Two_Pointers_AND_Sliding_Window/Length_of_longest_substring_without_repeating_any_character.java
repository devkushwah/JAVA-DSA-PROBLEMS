package Two_Pointers_AND_Sliding_Window;
import java.util.HashSet;

public class Length_of_longest_substring_without_repeating_any_character {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        HashSet<Object> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {


        // Test cases
        String[] testCases = {
                "abcabcbb",   // Expected Output: 3 ("abc")
                "bbbbb",      // Expected Output: 1 ("b")
                "pwwkew",     // Expected Output: 3 ("wke" or "kew")
                "",           // Expected Output: 0 (empty string)
                "au",         // Expected Output: 2 ("au")
                "dvdf",       // Expected Output: 3 ("vdf")
                "abcdef",     // Expected Output: 6 ("abcdef")
                "abba"        // Expected Output: 2 ("ab" or "ba")
        };

        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("Longest Unique Substring Length: " + lengthOfLongestSubstring(testCase));
            System.out.println("--------------------------");
        }
    }
}
