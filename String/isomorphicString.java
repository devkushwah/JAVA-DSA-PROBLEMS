package String;
import java.util.*;

public class isomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        // If lengths of s and t are different, they can't be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Create two hash maps for bi-directional mapping
        Map<Character, Character> hm1 = new HashMap<>(); // Maps characters from s -> t
        Map<Character, Character> hm2 = new HashMap<>(); // Maps characters from t -> s

        // Traverse each character in strings s and t
        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            // Check if there is a mapping from s -> t
            if (hm1.containsKey(original)) {
                // If there's already a mapping but it doesn't match current character in t
                if (hm1.get(original) != replacement) {
                    return false;
                }
            } else {
                // Establish mapping from s -> t
                hm1.put(original, replacement);
            }

            // Check if there is a mapping from t -> s
            if (hm2.containsKey(replacement)) {
                // If there's already a mapping but it doesn't match current character in s
                if (hm2.get(replacement) != original) {
                    return false;
                }
            } else {
                // Establish mapping from t -> s
                hm2.put(replacement, original);
            }
        }

        // If we passed all checks, the strings are isomorphic
        return true;
    }

    public static void main(String[] args) {

        // Test cases
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Are '" + s1 + "' and '" + t1 + "' isomorphic? " +isIsomorphic(s1, t1));

        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Are '" + s2 + "' and '" + t2 + "' isomorphic? " + isIsomorphic(s2, t2));

        String s3 = "paper";
        String t3 = "title";
        System.out.println("Are '" + s3 + "' and '" + t3 + "' isomorphic? " + isIsomorphic(s3, t3));
    }
}
