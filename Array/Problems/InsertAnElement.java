package Problems;

public class InsertAnElement {
        public static void insertElement(int[] arr, int n, int x, int pos) {
            if (pos < 0 || pos > n) {
                System.out.println("Invalid position to insert element.");
                return;
            }

            for (int i = n-1; i >= pos; i--) {
                arr[i+1] = arr[i];
            }

            arr[pos] = x;
            System.out.println("Element " + x + " inserted at position " + pos);

             int[] newArr = new int[n+1];
             System.arraycopy(arr, 0, newArr, 0, n+1);
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 5, 6};
            int n = arr.length;
            int x = 4;  // Element to insert
            int pos = 3;  // Position to insert

            insertElement(arr, n, x, pos);

             System.out.println("Array after insertion:");
             for(int i = 0; i < n+1; i++) {
                 System.out.print(arr[i] + " ");
             }
        }
    }


