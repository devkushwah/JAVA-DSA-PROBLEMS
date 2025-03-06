package Sorting.NonComparisonTypeSorting;

public class RadixSort {
        static int findMax(int[] arr){
            int mx = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > mx){
                    mx = arr[i];
                }
            }
            return mx;
        }
        static void countSort(int[] arr, int place){
            int n = arr.length;
            int[] output = new int[n];
            int[] count = new int[10];
            for(int i = 0; i < arr.length; i++){
                // isme ye change hai ki isme ones place ki frequency pta kar rahe hai bss
                count[(arr[i]/place)%10]++;
            }
            // Make prefix sum array of count array
            for(int i = 1; i < count.length; i++){
                count[i] += count[i-1];
            }

            // yaha tak to sab countSort jaisa tha aange bhi hoga bss thoda changes karna hai
            // [arr[i]] ke badle [(arr[i]/place)%10] karna hai bss

            for(int i = n-1; i >= 0; i--){
                int idx = count[(arr[i]/place)%10] - 1;
                output[idx] = arr[i];
                count[(arr[i]/place)%10]--;
            }
            // copy all elements of output to arr
            for(int i = 0; i < n; i++){
                arr[i] = output[i];
            }
        }

        static void radixSort(int[] arr){
            int max = findMax(arr); // max element nikaal liya
            // ye hum loop chalakar count sort laga rahe hai placewise, pehle ones -> tens -> hundreds
            for(int place = 1; max/place > 0; place *= 10){
                countSort(arr, place);
            }
        }

        public static void main(String[] args) {
            int[] arr = {170, 45, 75, 90, 802, 2};
            radixSort(arr);
            for(int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
        }

}
