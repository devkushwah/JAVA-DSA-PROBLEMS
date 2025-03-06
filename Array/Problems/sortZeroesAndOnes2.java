package Problems;
// (METHOD 3 VOID SE):  sort zeroes and ones starting me zeroes fir ones


import java.util.Scanner;

public class sortZeroesAndOnes2 {


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static void sortZeroesAndOnes(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
            if (arr[left] == 1 && arr[right] == 0) {
                swap(arr, left, right);
                left++;
                right--;
            }
            if (arr[left] == 0) {
                left++;
            }
            if (arr[right] == 1) {
                right--;
            }
        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER THE SIZE: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("ENTER ELEMENTS: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sortZeroesAndOnes(arr);


        for (int j = 0; j < n; j++) {
            System.out.print(" " + arr[j]); // fixed array name
        }

    }
}
