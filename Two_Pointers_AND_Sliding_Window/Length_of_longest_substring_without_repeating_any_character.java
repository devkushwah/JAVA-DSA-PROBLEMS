package Two_Pointers_AND_Sliding_Window;
import java.util.HashSet;

public class Length_of_longest_substring_without_repeating_any_character {
    public static int lengthOfLongestSubstring(String s) {
        // Optimal approach

        /*
        * step1: Create a hash array of size 256 and initialize it with -1, 256 size ka isliye kyoki koi bhi
        * character ho sakte hai to saare characters ke liye ek jagah banani padegi
        * step2:  agar hash array me current character already present hai aur r index aange hai l index se to l index ko hash array me r index ki (value + 1) karke l ko update kardo
        * Step3: Update the maximum length of the substring
        * step4: Update the r pointer index in the hash array
        * step5: Move the right pointer to the next character
        *
        * */

        if (s.length() == 0) return 0;

        int l = 0, r = 0, maxlength = 0;

        //Ste1: Create a hash array of size 256 and initialize it with -1, 256 size ka isliye kyoki koi bhi
        // character ho sakte hai to saare characters ke liye ek jagah banani padegi
        int[] hash = new int[256];
        for (int i=0; i<256; i++) {
            hash[i] = -1;
        }

        while (r < s.length()) {
            //step2:  agar hash array me current character already present hai aur r index aange hai l index se to l index ko hash array me r index ki (value + 1) karke l ko update kardo
            if(hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >= l) {
                l = hash[s.charAt(r)] + 1;

            }

            // Step3: Update the maximum length of the substring
            maxlength = Math.max(maxlength, r - l + 1);

            // step4: Update the r pointer index in the hash array
            hash[s.charAt(r)] = r;

            // step5: Move the right pointer to the next character
            r++;
        }
        return maxlength;

    }
    public static int lengthOfLongestSubstring2(String s) {
        // If string is empty, return 0
        if (s.isEmpty()) return 0;


        HashSet<Object> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // agar set me character hai to left ko aage badhao aur set se remove karo taaki next character ke liye
            // ready ho  jaye set me jagah banane ke liye aur maxLength ko update karo agar maxLength se bada hai to
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
