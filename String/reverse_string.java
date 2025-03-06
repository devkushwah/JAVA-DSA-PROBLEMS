package String;

public class reverse_string {
    /*
    * STEPS:-
    * 1. Pehle to string ko char array me convert karo kyoki string immutable hai aur hume in-place modification
    * karni hai
    * 2. Pura string reverse karo e.g. "the sky is blue" -> "eulb si yks eht"
    * 3. Ab har word ko reverse karo e.g. "eulb si yks eht" -> "blue is sky the"
    * 4. Aur last me return karte time space ko remove kar do agar hai to, kyoki last me space nahi hona chahiye
    * e.g. "blue is sky the" -> "blue is sky the"
    * */


    public static String reverseWords(String s) {
        // Step 1: Convert the string to a char array for in-place modification
        // e.g. "the sky is blue" -> ['t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e']
        char[] arr = s.toCharArray();

        // Step 2: Reverse the entire char array
        // e.g. ['t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'] -> ['e', 'u', 'l', 'b', ' ', 's', 'i', ' ', 'y', 'k', 's', ' ', 'e', 'h', 't']
        reverse(arr, 0, arr.length - 1);

        int n = arr.length;
        int i = 0, l = 0, r = 0;

        // Iterate over the char array to reverse each word
        while (i < n) {
            // i word ke last me jaate rahega aur r ko apne barabar karte jaayga aur agar i ke chalte chalte bich me
            // space
            // aa jata hai to ruk jana hai ya i poora traverse ho chuka ho tab ruk jana hai
            while (i < n && arr[i] != ' ') {
                // i ko aange bhadaao aur r ko bhi aange bhadaao
                arr[r++] = arr[i++];     // arr[r] = arr[i];
                                        // r++;
                                        // i++;
            }

            if (l < r) {   // l < r means word hai, agar l == r hai to space hai
                // while loop me r update hoga aur usse pata chlega ki r kaha rukega wo space aane par rukega aur
                // agar space aaya to l se leke r-1 tak reverse karna hai
                // Step 3: agar r aange hai l ke to l se leke r tak revser kardo
                reverse(arr, l, r - 1);

                // words reverse ke baad ek space bhi dena hai agar r < n hai to
                if (r < n) {
                    arr[r++] = ' ';
                }

                // revser karne ke baad aur space daalne ke baad l ko r ke equal kar do kyoki ab naya word start hoga
                l = r;
            }


            i++; // Skip over spaces
        }

        // new String(arr, start, length) -> 0 se leke (r-1 || r) tak ka string banega
        // agar (r > 0) hai aur (r-1) par space hai to (r-1) tak ka string lena hai nahi to (r) tak ka string lena hai

        return new String(arr, 0, r > 0 && arr[r - 1] == ' ' ? r - 1 : r);
    }

    // Helper function to reverse characters in the array between start and end indices
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {


        // Test case 1
        String s1 = "  the sky   is blue ";
        System.out.println("Original: \"" + s1 + "\"");
        System.out.println("Reversed words: \"" + reverseWords(s1) + "\"");

        // Test case 2
        String s2 = "  hello world  ";
        System.out.println("Original: \"" + s2 + "\"");
        System.out.println("Reversed words: \"" + reverseWords(s2) + "\"");

        // Test case 3
        String s3 = "a good   example";
        System.out.println("Original: \"" + s3 + "\"");
        System.out.println("Reversed words: \"" + reverseWords(s3) + "\"");

        // Test case 4
        String s4 = "singleWord";
        System.out.println("Original: \"" + s4 + "\"");
        System.out.println("Reversed words: \"" + reverseWords(s4) + "\"");
    }
}
