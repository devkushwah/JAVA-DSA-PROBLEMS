package PrefixSum;// Prefix Sum Array (worst Approach)


import java.util.Scanner;

class PrefixSumArray2{

    static int[] prefixSum(int[] arr){
        int n = arr.length;

        int[] pref = new int[n];
        pref[0] = arr[0];

          for(int i = 1; i<n; i++){
            pref[i] = pref[i-1] + arr[i];
        }
        return pref;
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

        int[] pref = prefixSum(arr);
        prefixSum(arr);
        print(pref);
    }
}
