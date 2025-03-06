package Problems;

import java.util.Scanner;

public class repeatingNumber {

    public static int firstrepeatingNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER THE SIZE OF ARRAY: ");

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("ENTER THE ELEMENTS OF AN ARRAY: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

    System.out.print("repeatingNumber: " + firstrepeatingNumber(arr));


    }
}
