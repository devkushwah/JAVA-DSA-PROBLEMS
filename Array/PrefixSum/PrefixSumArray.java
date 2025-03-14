package PrefixSum;// Prefix Sum Array ( Best Approach )


import java.util.Scanner;

class PrefixSumArray{

    static void prefixSum(int[] arr){
        int n = arr.length;

          for(int i = 1; i<n; i++){
            arr[i] = arr[i] + arr[i-1];
        }
    }

    static void print(int[] arr){
        int n = arr.length;
        for(int i = 0; i<n; i++){


                System.out.print(arr[i] +" ");


        }
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

        prefixSum(arr);
        print(arr);
    }
}
