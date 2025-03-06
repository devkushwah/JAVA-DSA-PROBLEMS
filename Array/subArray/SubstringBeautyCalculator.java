package subArray;

public class SubstringBeautyCalculator {

    // Function to calculate the beauty of substrings
    public static int beautySum(String s) {
        //ye humne ek variable bana liya aur yehi humara ans rahega
        int totalBeauty = 0;

        // substring ke 2 loop lagte hai, aur fir ASCI values
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26]; // Frequency array for characters in the substring

            // Iterate through each ending index of the substring
            for (int j = i; j < s.length(); j++) {
                // Increment frequency of the current character
                freq[s.charAt(j) - 'a']++;

                // Calculate beauty for the current substring
                totalBeauty += calculateBeauty(freq);
            }
        }

        return totalBeauty;
    }

    // Function to calculate the beauty of a substring based on frequency array
    private static int calculateBeauty(int[] freq) {
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;

        // Find the maximum and minimum non-zero frequencies
        for (int f : freq) {
            if (f > 0) { // Ignore zero frequencies
                maxFreq = Math.max(maxFreq, f);
                minFreq = Math.min(minFreq, f);
            }
        }

        // Return the beauty of the substring (difference between max and min frequencies)
        return maxFreq - minFreq;
    }

    public static void main(String[] args) {
        // Input string
        String s = "aabcb";

        // Calculate and print the total beauty of substrings
        int result = beautySum(s);
        System.out.println("Total beauty of substrings: " + result);
    }
}
