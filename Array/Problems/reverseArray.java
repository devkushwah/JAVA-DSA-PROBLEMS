package Problems;// REVERSE OF ARRAY (METHOD 1)


import java.util.Scanner;

class reverseArray {

    static int[] reverse(int[] arr){ // fixed the return type and the parameter
        int n = arr.length;
        int[] brr = new int[n]; // fixed array declaration

        for(int i = 0; i<n; i++){
            brr[i] = arr[n-1-i]; // fixed the array assignment
        }
        return brr; // fixed return statement
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER THE SIZE: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("ENTER ELEMENT: ");

        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] reversedArr = reverse(arr); // fixed method call

        for( int j = 0; j<n; j++) {
            System.out.print( " " + reversedArr[j] ); // fixed array name
        }
    }
}
