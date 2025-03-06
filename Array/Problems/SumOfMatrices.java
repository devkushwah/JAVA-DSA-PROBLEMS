package Problems;// Sum Of Two Matrices
import java.util.Scanner;

class SumOfMatrices {
    static void print(int[][] arr) {                   // Print Method Print karane ke Liye
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void add(int[][] a, int r, int c, int[][] b, int r1, int c1) {      // Add Method Add karane ke Liye
        int[][] sum = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        print(sum);
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

         // Matrix 2  Ke Liye
        System.out.print("Enter The Number Of Rows And Columns: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] b = new int[r1][c1];

        System.out.println("Enter The Elements Of Matrix ");

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        add(a, r, c, b, r1, c1);
        // System.out.println("Sum of the matrices: ");              // Aise bhi Print Krba Skte hai
        // print(sum1);                                            // Yaha print Method declare kar diya

    }
}
