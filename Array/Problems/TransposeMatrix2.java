package PrefixSum;// Transpose Of Matrix without Any extra Array

import java.util.Scanner;

class TransposeMatrix2{

    static void transpose(int [][] arr, int r, int c){      // This transpose without  an extra array
        for (int i = 0; i < c; i++) {
            for (int j = i; j < r ; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }


    static void print(int[][] arr) {                   // Print Method Print karane ke Liye
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {          // Main Method Yha Se Shuru
        Scanner sc = new Scanner(System.in);

        // Matrix 1 Ke liye
        System.out.print("Enter The Number Of Rows And Columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];

        System.out.println("Enter The Elements Of Matrix ");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        System.out.println("MAtrix 1: ");

        transpose(a, r, c);       // Pehele transpose fir Print
         print (a);
    }
}