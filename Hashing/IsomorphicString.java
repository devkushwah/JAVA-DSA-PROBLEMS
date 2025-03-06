package Hashing;
import java.util.*;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> used = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Agar c1 pehle se mapped hai
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false; // Mismatch case
            }
            // Agar c1 mapped nahi hai, toh check karo c2 pehle se kisi aur ka mapping toh nahi bana
            else {
                if (used.containsKey(c2)) return false; // c2 kisi aur ka mapped hai
                map.put(c1, c2);
                used.put(c2, true); // Mark c2 as used
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "egg", t1 = "add";
        System.out.println("Example 1: " + s1 + " & " + t1 + " → " + isIsomorphic(s1, t1)); // true

        // Example 2
        String s2 = "foo", t2 = "bar";
        System.out.println("Example 2: " + s2 + " & " + t2 + " → " + isIsomorphic(s2, t2)); // false

        // Example 3
        String s3 = "paper", t3 = "title";
        System.out.println("Example 3: " + s3 + " & " + t3 + " → " + isIsomorphic(s3, t3)); // true

    }
}

