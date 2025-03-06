package BinarySearch.OnArrays;

public class SearchInsertPosition  {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0; int high = n-1;
        int ans = n;// agar tumne (n-1) index se bhi bada target number de dia to....left poora neglect hoga, array
        // hee poora neglect...isliye ans = n index hoga

        while (low <= high) {
            int mid = low + (high - low) / 2;   // int mid = (low + high)/2

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9};
        int target = 10;
        int result = searchInsert(nums, target);
        System.out.println("Index to Insert Target: " + result);
    }
}
