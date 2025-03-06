package Special_tricks;
import java.util.Arrays;

public class Khudka_Hashmap_banana_wo_bhi_index_ke_sath {

        public static void main(String[] args) {
            // Input array
            int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5};

            // Process the array using a custom 2D array
            int n = nums.length;
            int[][] dp = new int[n][2];

            // Populate the 2D array
            for (int i = 0; i < n; i++) {
                dp[i][0] = nums[i]; // Store the value
                dp[i][1] = i;       // Store the original index
            }

            // Sort the 2D array based on the values (dp[i][0])
            Arrays.sort(dp, (a, b) -> a[0] - b[0]);

            // Print the sorted 2D array
            System.out.println("Sorted Array with Indices:");
            for (int i = 0; i < n; i++) {
                System.out.println("Value: " + dp[i][0] + ", Original Index: " + dp[i][1]);
            }

            // Example use case: Create a new array with only the sorted values
            int[] sortedValues = new int[n];
            for (int i = 0; i < n; i++) {
                sortedValues[i] = dp[i][0];
            }

            // Print the sorted values
            System.out.println("Sorted Values:");
            System.out.println(Arrays.toString(sortedValues));
        }


}
