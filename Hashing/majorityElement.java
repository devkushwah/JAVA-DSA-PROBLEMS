package Hashing;

import java.util.HashMap;

public class majorityElement {

    private static String[] args;

    static void hashMap(int[] arr) {
        // Step 1: Find frequency of each element using a HashMap
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Step 2: Populate the HashMap with element frequencies
        for (int j : arr) {
            // Increment count if element already exists, else add it with count 1
            hm.put(j, hm.getOrDefault(j, 0) + 1);
        }

        // Step 3: Check if any element appears more than n/2 times
        for (int key : hm.keySet()) {
            if (hm.get(key) > n / 2) {
                System.out.println(key);  // Majority element found
                return;  // Since there's only one majority element, exit after printing
            }
        }

        // Step 4: If no majority element exists
        System.out.println("No majority element");
    }

    public static void main(String[] args) {
        majorityElement.args = args;
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        hashMap(arr);  // Output will be 4 since it appears 5 times out of 9
    }
}
