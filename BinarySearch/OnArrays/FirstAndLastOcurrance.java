package BinarySearch.OnArrays;

class FirstAndLastOccurrence {
    // First and Last occurrance of same element

    static int[] linearSearch(int[] nums, int n, int target){  // Linear Search

        int first = -1, last = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                if(first == -1)
                    first = i;
                last = i;
            }
        }
        return new int[]{first, last};
    }
    static int firstOccurrence(int[] arr, int n, int k){
        int first = -1;
        int low = 0, high = n-1;

        while (low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == k){
                first = mid;
                high = mid - 1;
            }
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return first;
    }

    static int lastOccurrence(int[] arr, int n, int k){
        int last = -1;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == k){
                last = mid;
                low = mid + 1;
            }
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return last;
    }

    public static int[] binarySearch(int[] arr, int n, int k){  //Binary Search
        if (n == 0) return new int[]{-1, -1};

        int first = firstOccurrence(arr, n, k);
        if(first == -1) return new int[]{-1, -1};
        int last = lastOccurrence(arr, n, k);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 8, 11,4, 13};
        int n = arr.length, k = 4;
//      int[] ans = binarySearch(arr, n, k);  //Binary Search
        int[] ans = linearSearch(arr,n,  k);  //Linear Search
        System.out.println("Indexes of first and last positions of same element are: "
                + ans[0] + " " + ans[1]);
    }
}
