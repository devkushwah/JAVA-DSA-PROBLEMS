package BinarySearch;

public class Implementation {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Avoid potential integer overflow by using this expression
            // int mid = (low + high)/2
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // If the element is not found, it's better to return -1 immediately after the loop
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 22, 25, 33, 56, 59, 80};  // Ensure that the array is sorted for binary search
        int idx = search(arr, 81);  // Change the target value to an element present in the array
        if (idx != -1) {
            System.out.println("Element found at index: " + idx);
        } else {
            System.out.println("Element not found");
        }
    }
}
