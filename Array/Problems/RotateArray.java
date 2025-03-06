package Problems;//Rotate an array

import java.util.Scanner;

class RotateArray{

static int[] reverse(int[] arr, int si, int li){                          // (si= starting index, li= last index)

    for(int i = si, j = li; i<j; i++, j--){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    return arr;

}

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER THE SIZE: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("ENTER ELEMENTS: ");

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // int k = 3;

        System.out.print("ENTER THE ROTATION NO.(K): ");
        int k = sc.nextInt();

        k = k%n;                                  //Another Mehod

                                        //If arr= {1 2 3 4 5 6 7}
        reverse(arr, 0, n-1);           // Then, P1= {1 2 3} and P2= {4  5 6 7}
        reverse(arr, 0, k-1);           // ==> reverse(P1) + reverse(P2)
        reverse(arr, k, n-1);           // reverse(reverse(P1) + reverse(P2))

        for(int j = 0; j<n; j++)
        System.out.print( " " +arr[j]);
    }

}