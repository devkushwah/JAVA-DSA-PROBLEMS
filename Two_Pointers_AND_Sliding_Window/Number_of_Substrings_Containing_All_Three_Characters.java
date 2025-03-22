package Two_Pointers_AND_Sliding_Window;

public class Number_of_Substrings_Containing_All_Three_Characters {

    // humne iss code me optimal tareeke se saare substrings banaay hai jo a, b, c characters ko atleast ek baar
    // conatins karta hai
    public static int numberOfSubstrings(String s) {
        int[] lastseen = { -1, -1, -1 }; // To store last index of 'a', 'b', 'c'
        int count = 0;


        for (int i = 0; i < s.length(); i++) {
            lastseen[s.charAt(i) - 'a'] = i; // Store the last occurrence index of the character

            // If all three characters have appeared at least once
            // ye substrings ka count hai jo a, b, c sabhi characters ko atleast ek baar contain karte hai in the
            // substring
            if (lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1) {
                count += 1 + Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
            }
        }

        return count;
    }

    public static void main(String[] args) {


        // Sample test cases
        String[] testCases = { "abcabc", "abc", "aabbcc", "aabb", "abacb" };

        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + numberOfSubstrings(test));
            System.out.println("----------------------------");
        }
    }
}
