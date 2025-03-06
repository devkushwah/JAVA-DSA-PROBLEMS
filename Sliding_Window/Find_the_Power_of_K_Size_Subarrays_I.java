package Sliding_Window;
import java.util.*;

public class Find_the_Power_of_K_Size_Subarrays_I {
    // Bruth-Force_Approach
    public static int[] resultsArray_1(int[] nums, int k) {
        int length = nums.length;
        // result = [8 - 3 + 1] = 6 length of result array
        int[] result = new int[length - k + 1];

        for (int start = 0; start <= length - k; start++) {
            // ye humne flag de diya agar aange koi dikkat nahi hui to consecutive hee manenge
            boolean isConsecutiveAndSorted = true;

            // Check if the current subarray is sorted and consecutive
            //NOTE: [start + k + 1] karke k hee aayga kyoki humara sub-array k = 3 size ka hoga
            for (int index = start; index < start + k - 1; index++) {
                if (nums[index + 1] != nums[index] + 1) {
                    isConsecutiveAndSorted = false;
                    break;
                }
            }

            // If valid, take the maximum of the subarray, otherwise set to -1
            if (isConsecutiveAndSorted) {
                result[start] = nums[start + k - 1];
            } else {
                result[start] = -1;
            }
        }

        return result;
    }

    // Better Approrach
    public static int[] resultsArray_2(int[] nums, int k) {
        int length = nums.length;
        // same as first code
        int[] result = new int[length - k + 1];
        //  Ek Deque banaya gaya hai jo sliding window ke indices ko store karega.
        Deque<Integer> indexDeque = new ArrayDeque<>();

        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            // Remove elements that are out of the window
            if (!indexDeque.isEmpty() && indexDeque.peekFirst() < currentIndex - k + 1) {
                indexDeque.pollFirst();
            }

            // Check if current element breaks the consecutive and sorted condition
            if (!indexDeque.isEmpty() && nums[currentIndex] != nums[currentIndex - 1] + 1) {
                indexDeque.clear(); // Invalidate the entire deque if condition breaks
            }

            // Add current element index to the deque
            indexDeque.offerLast(currentIndex);

            // Check if the window is of size k and update result
            if (currentIndex >= k - 1) {
                if (indexDeque.size() == k) { // Valid window of size k
                    result[currentIndex - k + 1] = nums[indexDeque.peekLast()];
                } else {
                    result[currentIndex - k + 1] = -1; // Not valid, return -1
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 5, 6, 7, 8, 10};
        int k = 3;

//        int[] result = resultsArray_1(nums, k);
        int[] result = resultsArray_2(nums, k);

        System.out.println("Result Array: " + Arrays.toString(result));
    }
}
