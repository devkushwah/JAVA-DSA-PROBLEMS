package Hashing;
import java.util.*;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        // If lengths of s and t are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Initialize HashMap to store character frequencies for string s
        HashMap<Character, Integer> hm = new HashMap<>();

        // Populate the HashMap with frequencies of characters in s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        // Check each character in t and balance the HashMap
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // If ch is not in the map, or if its frequency would go below zero, return false
            if (!hm.containsKey(ch)) {
                return false;
            } else if (hm.get(ch) == 1) {
                hm.remove(ch);  // Remove character if its count becomes zero
            } else {
                hm.put(ch, hm.get(ch) - 1);  // Decrement the frequency
            }
        }

        // Check if HashMap is empty; if so, they are anagrams
        return hm.size() == 0;
    }

    public static void main(String[] args) {


        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Are '" + s1 + "' and '" + t1 + "' anagrams? " + isAnagram(s1, t1));

        String s2 = "rat";
        String t2 = "car";
        System.out.println("Are '" + s2 + "' and '" + t2 + "' anagrams? " + isAnagram(s2, t2));
    }
}
