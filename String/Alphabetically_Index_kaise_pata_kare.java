package String;

public class Alphabetically_Index_kaise_pata_kare {


    public static boolean checkIfPangram(String sentence) {
        int[] arr = new int[26]; // To track the presence of each letter

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            int index = ch - 'a';

            if (ch >= 'a' && ch <= 'z') { // Ensure only lowercase letters are processed
                arr[index] = 1; // Mark the letter as seen
            }
        }

        // Check if all 26 letters are seen
        for (int j = 0; j < 26; j++) {
            if (arr[j] == 0) return false;
        }
        return true;
    }

   public static  String sort(String s) {
        // Create an array to store the frequency of each character
        int[] arr = new int[26];
        StringBuilder ans = new StringBuilder(s.length());

       // sabse pehele index nikaalunga sabhi characters ke alphabetically oredr me
        for (int i = 0; i < s.length(); i++) {
            char charac = s.charAt(i);
            int index = charac - 'a'; // Calculate the index for 'a' to 'z'
            arr[index]++;
        }


        for (int i = 0; i < 26; i++) {
            // ab hum saare characters nikaalenge, aur unki frquencies ke hisaab se unko print krenge

            // ab characters niklenge ek ek karke
            char ch = (char) ('a' + i);;    // 'a' + 0  = 'a'
                                            // 'a' + 1 = 'b'
                                            // 'a' + 2 = 'c'

            // ab inn characters ki frquencies ke hisaaab se inko print krenge
            while (arr[i] > 0) {
                ans.append(ch);
                arr[i]--;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {


        // Example 1: Valid pangram
        String example1 = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println("Example 1: " + example1);
        System.out.println("Is Pangram: " + checkIfPangram(example1)); // Output: true

        // Example 2: Missing some letters
        String example2 = "hello world";
        System.out.println("\nExample 2: " + example2);
        System.out.println("Is Pangram: " + checkIfPangram(example2)); // Output: false

        // Example 3: All letters but repeated
        String example3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("\nExample 3: " + example3);
        System.out.println("Is Pangram: " + checkIfPangram(example3)); // Output: true

        // Example 4: Empty string
        String example4 = "";
        System.out.println("\nExample 4: " + example4);
        System.out.println("Is Pangram: " + checkIfPangram(example4)); // Output: false


//        sort a string examples

//        Example 1:
        String s1 ="edcab";
        System.out.println("\nExample 1 "+ s1);
        System.out.println("Sorted String: " + sort(s1));

        // Example 2:
        String s2 ="banana";
        System.out.println("\nExample 2 "+ s2);
        System.out.println("Sorted String: " + sort(s2));



    }
}
