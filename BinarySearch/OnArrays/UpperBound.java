package BinarySearch.OnArrays;

public class UpperBound {
        public static int upperBound(int[] arr, int x, int n) {
            // Write your code here.
            int low = 0, high = n - 1;
            int ans = n;

            while (low <= high) {
                int mid = low + (high - low) / 2;   // int mid = (low + high)/2
                //may be an answer
                if (arr[mid] > x) {
                    ans = mid;
                    //look for more small index on left
                    high = mid - 1;
                } else low = mid + 1;  // look for right
            }
            return ans;
        }

        public static void main(String[] args) {
            int[] arr = {1, 3, 5, 7, 9};
            int n = arr.length;
            int x = 6;
            int result = upperBound(arr, x, n);
            System.out.println("Upper bound of " + x + " is at index: " + result);
        }
    }


