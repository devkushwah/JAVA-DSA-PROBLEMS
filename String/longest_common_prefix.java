package String;

import java.util.Arrays;

public class longest_common_prefix {
    public static String longestCommonPrefix(String[] strs) {
        // Return empty string if input array is empty
        if (strs == null || strs.length == 0) return "";

        StringBuilder result = new StringBuilder();

        // Sort the array to bring lexicographically smallest and largest strings to front and end
        Arrays.sort(strs);   // like:  abcde.....

        // Get the first and last strings in the sorted array
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        // Compare characters of the first and last string
        for (int i = 0; i < first.length; i++) {
            if (i >= last.length || first[i] != last[i])  break;

            result.append(first[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {


        // Test cases
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs2)); // Output: ""

        String[] strs3 = {"interview", "intermediate", "internal", "internet"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs3)); // Output: "inte"
    }
}
