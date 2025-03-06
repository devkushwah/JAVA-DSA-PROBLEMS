package Problems;// Rotation Of Matrix without Any extra Array

import java.util.Scanner;

class RotateMatrix{

    static void reversedArray(int[] arr){
        int i = 0, j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static  void rotate(int[][] a, int n){

        // Pehele  Transpose Fir Reverse Rotate Ho jaayga
        transpose(a, n, n);

        // Reversed Each Row Of Transposed Matrix
        for(int i  = 0; i<n; i++){


            reversedArray(a[i]);

        }
    }


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
        System.out.println("Rotate MAtrix : ");

        rotate(a, r);
        // transpose(a, r, c);       // Ek baar transpose krdoge to neeche upper and lower row's exchange ho jaaygi
        print (a);
    }
}