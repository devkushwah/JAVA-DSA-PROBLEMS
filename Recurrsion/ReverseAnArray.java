public class ReverseAnArray {
 // Reverse An array without two pointer, only with pinter
    static void printArray(int arr[], int n) {
        System.out.print("Reversed array is:- \n");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
        public static int[] reverseArrayIteratively(int n, int[] nums) {
            // Iteratively
            int[] brr = new int[n];

            for (int i = n - 1; i >= 0; i--) {
                brr[n - 1 - i] = nums[i];
            }

            return brr;
        }
    static void reverseArrayRecurr(int arr[], int start, int end) {
        //Recurrsively
        if (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            reverseArrayRecurr(arr, start + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        //reverseArrayIteratively(n, arr);
         reverseArrayRecurr(arr, 0, n - 1);
        printArray(arr, n);

    }
    }


