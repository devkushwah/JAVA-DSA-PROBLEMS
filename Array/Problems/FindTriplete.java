package Problems;//FIND THE TOTAL NUMBER OF TRIPLETS WHOSE SUM IS EQUAL TO THE GIVEN VALUE X

import java.util.Scanner;

class FindTriplete{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
         System.out.print("ENTER THE SIZE OF AN ARRAY: ");
        int n = sc.nextInt();
        int[] arr= new int[n];

        System.out.print("ENTER THE ELEMENTS OF AN ARRAY: ");
       for( int i= 0; i<arr.length; i++)
       arr[i]  = sc.nextInt();

       System.out.print("ENTER THE NUMBER YOU WANT PAIR OF: ");
       int x= sc.nextInt();

       int ans=0;

       for(int i= 0; i<n; i++){
           for(int j= i+1; j<n; j++){
               for(int k=j+1; k<n; k++){

                   if(arr[i]+arr[j]+arr[k]==x)
              ans++;

               }


           }
       }


       System.out.print("THE NUMBER OF PAIRS OF "+x+ " IS: " +ans);
    }
}