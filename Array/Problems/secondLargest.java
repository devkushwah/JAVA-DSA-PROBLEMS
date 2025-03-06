package Problems;// FIND THE SECOND MAXIMUM ELEMENT IN THE ARRAY

import java.util.Scanner;

class secondLargest{

    static int findMax(int[] arr){
    int  mx=Integer.MIN_VALUE;

    for(int i = 0; i<arr.length; i++){
        if(mx<arr[i]){
            mx=arr[i];
        }
    }
    return mx;                              // ISME MX PTA CHL JAAYGA

    }

    static int findsecondMax(int[] arr){   //CODE CHALNA YHA SE START KAREGA
        int mx = findMax(arr);             // ISPR AANE KE BAAD UPR JAAYGA

        for(int i=0; i<arr.length; i++){
            if(mx == arr[i]){
                arr[i] = Integer.MIN_VALUE;  // YE SBKO MINUS INF. KRDEGA
            }

        }

        int secondMax = findMax(arr);       //  YHA SE BAPIS CHLEGA SBSE UPR MAX DHUNDE JOKI SIRF SECOND MILEGA
        return secondMax;
    }

public static void main (String[] args) {
    Scanner sc =new Scanner(System.in);

    System.out.print("ENTER THE SIZE OF ARRAY: ");

    int n= sc.nextInt();
    int[] arr= new int[n];

    System.out.print("ENTER THE ELEMENTS OF AN ARRAY: ");

    for( int i=0; i<n; i++){
        arr[i] = sc.nextInt();
    }


    System.out.print("THIS IS SECOND MAX NUMBER: "  +findsecondMax(arr) );   /* I THINK JO METHOD BANATE HAI
                                                                              WOHI LETE HAI PRINT ME*/
}



}