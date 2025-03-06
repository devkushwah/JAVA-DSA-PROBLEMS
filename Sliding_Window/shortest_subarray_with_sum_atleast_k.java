package Sliding_Window;

import java.util.Deque;
import java.util.LinkedList;

public class shortest_subarray_with_sum_atleast_k {
    // Brute force approach
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        // Brute force approach to find the shortest subarray
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; // Shortest length possible for this start index
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    // Better Approach - with [Sliding window, PrefixSum, subArray, dequeue]
    public static int shortestSubarray2(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Remove elements from the deque if their subarray sum >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Maintain deque in increasing order of prefix sums
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {


        // Test cases
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println("Output for nums = [1], k = 1: " + shortestSubarray2(nums1, k1)); // Output: 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println("Output for nums = [1, 2], k = 4: " + shortestSubarray2(nums2, k2)); // Output: -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println("Output for nums = [2, -1, 2], k = 3: " + shortestSubarray2(nums3, k3)); // Output: 3

        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 11;
        System.out.println("Output for nums = [1, 2, 3, 4, 5], k = 11: " + shortestSubarray2(nums4, k4)); // Output: 3
    }
}
