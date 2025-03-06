package String.StringBuilder;
//NOTE: sabse pehle uppercase vowels aayenge fir lowercase vowels aayenge in ascending order
public class Sort_Vowels_in_a_String {

    public static String sortVowels(String s) {

        // 2 array jimse characters ki frequencies save hongi
        int[] lower = new int[26];
        int[] upper = new int[26];
        StringBuilder vowels = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);

        // sentence me sabhi lowercase aur uppercase vowels ki frequency nikaal lii
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                lower[ch - 'a']++;
            } else if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                upper[ch - 'A']++;
            }
        }



        // Problem statement me diya hai ki pehele badi ASCI Value aaygi vowels order me isliye phle uppercase fir
        // lowercase isse hum orderly vowels ko collect kar lenge aur phir original string me vowels ko replace kar
        // denge in order me e.g. "helloWORLD" -> "OeO

        // Collect uppercase vowels in order
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            while (upper[i] > 0) {
                vowels.append(ch);
                upper[i]--;
            }
        }

        // Collect lowercase vowels in order
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            while (lower[i] > 0) {
                vowels.append(ch);
                lower[i]--;
            }
        }

        // Replace vowels in the original string
        int vowelIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("aeiouAEIOU".indexOf(ch) != -1) {     // if ("aeiouAEIOU".contains(String.valueOf(ch)))
                sb.setCharAt(i, vowels.charAt(vowelIdx));
                vowelIdx++;
            }
        }

        return sb.toString();
    }

        public static void main(String[] args) {

            // Test case 1
            String example1 = "helloWORLD";
            System.out.println("Original: " + example1);
            System.out.println("Sorted Vowels: " + sortVowels(example1)); // Output: "hOlleWoRLD"

            // Test case 2
            String example2 = "aeiouAEIOU";
            System.out.println("\nOriginal: " + example2);
            System.out.println("Sorted Vowels: " + sortVowels(example2)); // Output: "AEIOUaeiou"

            // Test case 3
            String example3 = "Programming";
            System.out.println("\nOriginal: " + example3);
            System.out.println("Sorted Vowels: " + sortVowels(example3)); // Output: "Pragrimmong"
        }


}
