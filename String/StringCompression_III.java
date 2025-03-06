package String;

public class StringCompression_III {
    public static String compressedString(String word) {
        // StringBuilder to store the compressed string
        StringBuilder sb = new StringBuilder(" ");

        // Position pointer to traverse the input string
        int pos = 0;

        // Process the string until we reach its end
        while (pos < word.length()) {
            int consecutiveCount = 0; // Counter for consecutive characters

            // Current character
            char currentChar = word.charAt(pos);

            // Count consecutive occurrences of the current character (up to 9)
            while (
                    pos < word.length() &&
                            consecutiveCount < 9 && // Limit to 9 as per the problem constraints
                            word.charAt(pos) == currentChar
            ) {
                consecutiveCount++;
                pos++;
            }

            // Append the count and the character to the compressed string
            sb.append(consecutiveCount).append(currentChar);
        }

        return sb.toString(); // Return the compressed result
    }

    public static void main(String[] args) {


        // Example input
        String input = "aaabbbbcccccdddddd";

        // Get the compressed result
        String compressedResult = compressedString(input);

        // Print the result
        System.out.println("Input String: " + input);
        System.out.println("Compressed String: " + compressedResult);
    }
}
