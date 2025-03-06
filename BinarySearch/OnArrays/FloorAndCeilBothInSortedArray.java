package BinarySearch.OnArrays;

public class FloorAndCeilBothInSortedArray {
        static int findFloor(int[] arr, int n, int x) {  //neeche wali zameen
            // Reverse of Lower Bound:- Sabse bada index jo target number se chhota ya barabar ho...ab tum chhota
            // dhund rahe to kuch changes hai isme, isme aange kow bhadega naaki high peeche jaayga
            int low = 0, high = n - 1;
            int ans = -1; // agar tumne 0 index se bhi chhota target number de dia to....right poora neglect hoga, array
            // hee poora neglect...isliye ans = -1 index hoga

            while (low <= high) {
                int mid = low + (high - low) / 2; // int mid = (low + high)/2
                // maybe an answer
                if (arr[mid] <= x) {
                    ans = arr[mid];
                    //look for smaller index on the left
                    low = mid + 1;
                } else {
                    high = mid - 1; // look on the right
                }
            }
            return ans;
        }

        static int findCeil(int[] arr, int n, int x) { // chhat
            // Lower Bound poora
            int low = 0, high = n - 1;
            int ans = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                // maybe an answer
                if (arr[mid] >= x) {
                    ans = arr[mid];
                    //look for smaller index on the left
                    high = mid - 1;
                } else {
                    low = mid + 1; // look on the right
                }
            }
            return ans;
        }
        public static int[] getFloorAndCeil(int[] arr, int n, int x) {
            int f = findFloor(arr, n, x);
            int c = findCeil(arr, n, x);
            return new int[] {f, c};
        }
        public static void main(String[] args) {
            int[] arr = {3, 4, 4, 7, 8, 10};
            int n = arr.length, x = 9;
            int[] ans = getFloorAndCeil(arr, n, x);
            System.out.println("The floor and ceil are: " + ans[0]
                    + " " + ans[1]);
        }
    }

