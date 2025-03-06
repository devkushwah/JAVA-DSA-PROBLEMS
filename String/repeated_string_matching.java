package String;
// by :- gate wala ladka haklaane vala(coder army)
public class repeated_string_matching {
    // Optimized substring check using indexOf
    // isse pata chalega ki string me humari substring present hai ya nahi
    public boolean isSubstring(String haystack, String needle) {
        return haystack.indexOf(needle) != -1;
    }

    public static int repeatedStringMatch(String a, String b) {
        // Handle edge cases for empty strings
        if (b.isEmpty()) return 1;
        if (a.isEmpty()) return -1;

        // If `a` equals `b`, one repetition is enough
        if (a.equals(b)) return 1;

        // repeat = 1 isliye ek substring ho match hee hai btana hai kitni repeatation hai
        int repeat = 1;
        StringBuilder temp = new StringBuilder(a);

        // Repeat string `a` until its length exceeds or equals `b`
        // substring repeat temp me jodhdi aur repeat bhi krdenge jab tak temp aange na kikal jaay b se
        while (temp.length() < b.length()) {
            temp.append(a);
            repeat++;
        }

        // Check if `b` is a substring of the current or one more repetition of `a`
        // ab check krenge ki temp me hune itna append krdiya, repeat++ krdia but temp me sahi pattern ban raha hai ya nahi
        if (temp.indexOf(b) != -1) {
            return repeat;
        }
        if (temp.append(a).indexOf(b) != -1) {
            return repeat + 1;
        }

        return -1; // `b` is not a substring even after extra repetition
    }

    // Main function to test the code
    public static void main(String[] args) {


        // Test cases
        System.out.println(repeatedStringMatch("abcd", "cdabcdab")); // Output: 3
        System.out.println(repeatedStringMatch("a", "aa")); // Output: 2
        System.out.println(repeatedStringMatch("abc", "wxyz")); // Output: -1
        System.out.println(repeatedStringMatch("", "a")); // Output: -1
        System.out.println(repeatedStringMatch("a", "")); // Output: 1
    }
}
