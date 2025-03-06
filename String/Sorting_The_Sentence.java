package String;

public class Sorting_The_Sentence {
    public static String sortSentence(String s) {
        // Validate input
        if (s == null || s.isEmpty()) {
            return ""; // Return empty string for invalid input
        }

        // sab words ko split krdenge taaki baadme unpr traverse kar sake
        // e.g. : ["is2" "sentence4" "This1" "a3"]
        String[] words = s.split(" ");

        // ab ek naya string array bana liya jisme hum words ko process krke daalenge
        String[] sortedWords = new String[words.length]; // size same hee rahega array hai

        // Process each word
        for (String word : words) {
            // Ensure the word has at least one character for position
            if (word.length() < 2) {
                throw new IllegalArgumentException("Invalid word format: " + word);
            }

            // yaha hum word ke last me wo integer nikaal rahe hai, uss integer se word ki position pata chalegi
            int position = word.charAt(word.length() - 1) - '0';

            // Ab humko word ki position pata chal chuki hai to usko sortedWords array me daalenge uss postion par
            // jo honi chaiye = substring ka use karke sirf word ko daalenge uss last integer ko nahi daalenge
            sortedWords[position - 1] = word.substring(0, word.length() - 1);
        }

        // ab join krdenge aur ye fir kuch iss prakar dhikega:
        // "This is a sentence"
        // "Me Myself and I"
        return String.join(" ", sortedWords);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);


//        System.out.println("Enter the scrambled sentence:");
//        String input = scanner.nextLine();

        // Call the sortSentence function and print the result

        System.out.println("Example 1:");
        String example1 = "is2 sentence4 This1 a3";
        System.out.println("Input: " + example1);
        System.out.println("Output: " + sortSentence(example1));

        System.out.println("Example 2:");
        String example2 = "Myself2 Me1 I4 and3";
        System.out.println("Input: " + example2);
        System.out.println("Output: " + sortSentence(example2));

        System.out.println("Enter the scrambled sentence:");
        try {
//            String result = sortSentence(input);
//            System.out.println("The sorted sentence is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

//        scanner.close();
    }
}
