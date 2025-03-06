package Sorting.ComparisonTypeSorting;

public class QuickSort2 {

        // Function to swap two elements in the array
        static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Function to partition the array and return the pivot index
        static int partition(int[] arr, int low, int high) {
            int pivot = arr[high]; // Choosing the last element as pivot
            int i = low - 1; // Index of smaller element

            // Partitioning the array
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1; // Returning the pivot index
        }

        // Function to perform Quick Sort
        static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                // Finding the partitioning index
                int pi = partition(arr, low, high);

                // Recursively sort elements before and after partition
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        // Utility function to print an array
        static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Main method to test Quick Sort
        public static void main(String[] args) {
            int[] arr = {10, 7, 8, 9, 1, 5};
            int n = arr.length;
            System.out.println("Array before sorting:");
            printArray(arr);

            // Applying Quick Sort
            quickSort(arr, 0, n - 1);

            System.out.println("Array after sorting:");
            printArray(arr);
        }
    }


