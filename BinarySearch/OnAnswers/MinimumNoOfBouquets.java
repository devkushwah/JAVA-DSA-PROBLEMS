package BinarySearch.OnAnswers;

public class MinimumNoOfBouquets {

    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {    // {7, 7, 7, 7, 13, 11, 12, 7}
            if (arr[i] <= day) {
                cnt++;
            }   //aur haa tum noOfB ko badal nhi rahe ho sirf usme plus kar rahe ho
            else {
                noOfB += (cnt / k);   // UnBloom aane tak ginna hai apn ko aur bouquets banana hai
                cnt = 0;              // aur fir zero karke firse start karna hai
            }
        }
        noOfB += (cnt / k);    // ye isliye agar last me UnBloom nahi mila tha Bouquets kaise banenge
        return noOfB >= m;
    }

    public static int roseGarden(int[] arr, int k, int m) {
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n) return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        for (int i = mini; i <= maxi; i++) {
            if (possible(arr, i, m, k))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = roseGarden(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }

}
