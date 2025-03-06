package String;
import java.util.*;

public class frequncy_sort {
    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();

        // Create an array of lists to store characters by their frequencies
        List<Character>[] arr = new ArrayList[s.length() + 1];

        // Create a map to store the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Fill the array with characters based on their frequency
        map.keySet().forEach(ch -> {
            int freq = map.get(ch);
            if (arr[freq] == null) {
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(ch);
        });

        // Build the result string by frequency order
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != null) {
                for (Character ch : arr[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {


        // Test case 1
        String s1 = "tree";
        System.out.println("Sorted by frequency (tree): " + frequencySort(s1));

        // Test case 2
        String s2 = "cccaaa";
        System.out.println("Sorted by frequency (cccaaa): " + frequencySort(s2));

        // Test case 3
        String s3 = "Aabb";
        System.out.println("Sorted by frequency (Aabb): " + frequencySort(s3));


    }
}
