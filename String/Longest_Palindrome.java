package String;

import java.util.Scanner;

public class Longest_Palindrome {

    public static int longestPalindrome(String s) {

        // frequency banane ke liye 2 array bana liye jinme String s ke characters ki frequencies hongi
        int[] lower = new int[26];
        int[] higher = new int[26];

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                // ye lower array me 'ch' ki frequency bata dii
                lower[ch - 'a']++;
            }
            // For uppercase alphabets
            else if (ch >= 'A' && ch <= 'Z') {
                // ye higher array me 'ch' ki frequency bata dii
                higher[ch - 'A']++;
            }
        }

        // Now ab sab characters ki frequencies nikaal lii hai

        // simple sa funda agar koi char freq me even hai to wo palindrome ka part hai
        // lekin freq odd waala sirf ek hee aayga bich me

        int count = 0;
        int odd = 0;    // freq me jo odd hoga usko bich me rakha jaayga

        for (int i=0; i < 26; i++) {
            // for even characters count
            if(lower[i] % 2 == 0) {
                count += lower[i];
            }
            else {
                // for odd characters just only 1 char is allowed
                count += lower[i] - 1;
                odd = 1;
            }
            // for even characters count
            if(higher[i] % 2 == 0) {
                count += higher[i];
            }
            else {
                // for odd characters just only 1 char is allowed
                count += higher[i] - 1;
                odd = 1;
            }
        }
        //lasr wo even aur odd waale characters ko jod do
        return count + odd;
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the string:");
            String input = scanner.nextLine();

            // Call the longestPalindrome function and print the result
            int result = longestPalindrome(input);
            System.out.println("The length of the longest palindrome that can be formed is: " + result);

            scanner.close();
        }


}
