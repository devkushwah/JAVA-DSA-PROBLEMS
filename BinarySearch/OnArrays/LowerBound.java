package BinarySearch.OnArrays;

public class LowerBound {
        public static int lowerBound(int []arr, int n, int x) {

            int low = 0, high = n-1;
            int ans = n;

            while(low<=high)
            {
                int mid = low + (high - low) / 2;  // int mid = (low + high)/2
                //may be an answer
                if(arr[mid] >= x){
                    ans = mid;
                    //look for more small index on left
                    high = mid-1;
                }
                else low = mid+1;  // look for right
            }
            return ans;
        }

        public static void main(String[] args) {
            int[] arr = {2, 3, 5, 7, 9};
            int n = arr.length;
            int x = 6;
            int result = lowerBound(arr, n, x);
            System.out.println("Lower bound of " + x + " is at index: " + result);
        }
    }


