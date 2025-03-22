package Two_Pointers_AND_Sliding_Window;

import Tree.Solution;

public class Max_Consecutive_Ones_III {
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLength = 0, zeroes = 0;

        while (r < nums.length) {
            // Step1: Count the number of zeroes in the current window
            if (nums[r] == 0) zeroes++;

            //Step2:
            // Jab zeroes limit se zyada ho jaye, left pointer ko move karo taaki window size decrease ho jaye aur
            // zeroes ko bhi decrease karo taaki window me se zeroes kam ho jaye aur window valid ho jaye

            // l pointer ko move kyo karenge? taaki window size decrease ho jaye aur zeroes ko bhi decrease karo
            // taaki window me se zeroes kam ho jaye aur aange waali window valid ho jaye
            while (zeroes > k) {
                if (nums[l] == 0) zeroes--;
                l++;
            }

            //Step3: Maximum valid subarray length store karo
            maxLength = Math.max(maxLength, r - l + 1);
            // Step4: Move the right pointer to the next character
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        System.out.println("Example 1 Output: " + longestOnes(nums1, k1));
        // Expected Output: 6

        // Example 2
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0};
        int k2 = 3;
        System.out.println("Example 2 Output: " + longestOnes(nums2, k2));
        // Expected Output: 9

        // Example 3
        int[] nums3 = {1,1,1,1,1};
        int k3 = 2;
        System.out.println("Example 3 Output: " + longestOnes(nums3, k3));
        // Expected Output: 5 (since all are already 1s)

        // Example 4
        int[] nums4 = {0,0,0,0,0};
        int k4 = 3;
        System.out.println("Example 4 Output: " + longestOnes(nums4, k4));
        // Expected Output: 3 (since we can flip at most 3 zeroes)
    }
}
