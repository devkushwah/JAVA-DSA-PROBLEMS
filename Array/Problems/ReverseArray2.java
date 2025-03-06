package Problems;// REVERSE OF ARRAY (METHOD 2)


import java.util.Scanner;

class ReverseArray2 {

    static int[] reverse(int[] arr){ // fixed the return type and the parameter
        int n = arr.length;

        for(int i = 0,j = n-1; i<j; i++,j--){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        }
        return arr;
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
