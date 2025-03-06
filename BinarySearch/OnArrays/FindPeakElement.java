package BinarySearch.OnArrays;

public class FindPeakElement {
    public static int binarySearch(int[] nums){
        int n = nums.length;
        if(n  == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int low = 1, high = n-2;
        while(low <= high){
            int mid = (low + high)/2;

            //If mid is the peak
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1])
                return mid;

            //If we are in the left
            if(nums[mid] > nums[mid-1]) low  = mid + 1;

                //If we are in the right or nums[mid] is the common point
            else high = mid-1;
        }
        // Dummy return statement
        return -1;

    }
        public static int linearsearch(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // Checking for the peak:
                if ((i == 0 || nums[i - 1] < nums[i])  // agar phli condition true hui to dusri dhkna nhi hai
                        && (i == n - 1 || nums[i] > nums[i + 1])) { // agar phli galat to dusri dhkna hai
                    return i;
                }
            }
            // Dummy return statement
            return -1;
        }

        public static void main(String[] args) {
            int[] arr = {1, 50, 3, 1, 5,6,4,9,5};
            int peakIndex = linearsearch(arr);
//            int peakIndex = binarySearch(arr);
            System.out.println("Peak element found at index: " + peakIndex);
        }
    }


