package String;

public class String_Compression_I {
    public static int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        int i = 0;

        while (i < n) {
            char curr_char = chars[i];
            int count = 0;

            // Find the duplicates
            while (i < n && chars[i] == curr_char) {
                count++;
                i++;
            }

            // Assign the character to the compressed array
            chars[index] = curr_char;
            index++;

            // If count is greater than 1, add it to the array as characters
            if (count > 1) {
                String count_str = Integer.toString(count);
                for (char ch : count_str.toCharArray()) {
                    chars[index] = ch;
                    index++;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {


        // Example test case
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int newLength = compress(chars);

        // Print compressed characters
        System.out.print("Compressed Array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("\nNew Length: " + newLength);

        // ----------------------------------------------------------------------------------------------------
        // This is second method

    //
            String str = "aaabbbcddeeee";

            String ans = ""  + str.charAt(0);
            int count = 1;

            for(int i=1; i<str.length(); i++){
                char curr = str.charAt(i);
                char prev = str.charAt(i-1);
                if(curr == prev) {
                    count++;
                }

                else {
                    if(count>1)  ans += count;
                    count = 1;
                    ans += curr;
                }
            }
            if(count>1)  ans += count;
            System.out.println(ans);







    }


}
