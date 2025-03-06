package Problems;// Multiplication Of Two Matrices

import java.util.Scanner;

class MultplyMatrix{
    static void print(int[][] arr) {                   // Print Method Print karane ke Liye
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void multiply(int[][] a, int r1, int c1, int[][] b, int r2, int c2) {      // Add Method Add karane ke Liye
       if(c1 != r2){
           System.out.print("Multiplication Not Possible - Dimension Wrong");
           return;
       }


        int[][] mul = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {

                /* Isme 'k' Ki Value (r2=c1) Dono Me Se Ek Lenge
                Loop Chalane Ke Liye..
                Ek Tareeke se Ye Length HAi Ki Kitni Baar Multiply Hoga Program Mein */

                for ( int k = 0; k<c1; k++){

                    mul[i][j] += a[i][k] * b[k][j];
                }

            }
        }

        print(mul);
    }

    public static void main(String[] args) {          // Main Method Yha Se Shuru
        Scanner sc = new Scanner(System.in);

        // Matrix 1 Ke liye
        System.out.print("Enter The Number Of Rows And Columns: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] a = new int[r1][c1];

        System.out.println("Enter The Elements Of Matrix ");

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

         // Matrix 2  Ke Liye
        System.out.print("Enter The Number Of Rows And Columns: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] b = new int[r2][c2];

        System.out.println("Enter The Elements Of Matrix ");

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }


           multiply(a, r1, c1, b, r2, c2);
        // add(a, r, c, b, r1, c1);
        // System.out.println("Sum of the matrices: ");
        // print(sum1);                                   // Yaha print Method declare kar diya(Return type)

    }
}
