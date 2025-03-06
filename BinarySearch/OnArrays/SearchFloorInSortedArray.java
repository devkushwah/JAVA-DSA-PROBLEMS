package BinarySearch.OnArrays;
// Dry karna hai isko
public class SearchFloorInSortedArray {
    static int findFloorByGPT(int[] arr, int n, long x)
    {
        if (x >= arr[n - 1]) {
            return n - 1;
        }

        if (x < arr[0]) {
            return -1;
        }

        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // int mid = (low + high)/2

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    static int floorSearchByGFG(int[] arr, int n, int x)
    {
        // If last element is smaller than x
        if (x >= arr[n - 1])
            return n - 1;

        // If first element is greater than x
        if (x < arr[0])
            return -1;

        // Linearly search for the first element
        // greater than x
        for (int i = 1; i < n; i++)
            if (arr[i] > x)
                return (i - 1);

        return -1;
    }


    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 4, 6, 10, 12, 14 };
        int n = arr.length;
        int x = 7;
      //  int index = findFloorByGPT(arr, n - 1, x);
        int index  = floorSearchByGFG(arr,n-1, x );
        if (index == -1)
            System.out.print("Floor of " + x
                    + " doesn't exist in array ");
        else
            System.out.print("Floor of " + x + " is "
                    + arr[index]);
    }

}
