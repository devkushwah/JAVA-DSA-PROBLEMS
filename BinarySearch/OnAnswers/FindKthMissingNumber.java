package BinarySearch.OnAnswers;

public class FindKthMissingNumber {
    //Linear Search -> time = O(n), sp. = o(1)
    public static int missingKLinearSearch(int[] vec, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (vec[i] <= k) k++; //shifting k
            else break;
        }
        return k;
    }

    public static int missingKBinarySearch(int[] vec, int n, int k) {
        //Binary Search -> time = O(n), sp. = o(1)
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;
//        int ans = missingKLinearSearch(vec, n, k);
        int ans = missingKBinarySearch(vec, n, k);
        System.out.println("The missing number is: " + ans);
    }




}
