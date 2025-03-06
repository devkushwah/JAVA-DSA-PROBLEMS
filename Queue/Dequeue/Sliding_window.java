package Queue.Dequeue;

import java.util.*;

public class Sliding_window {

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

