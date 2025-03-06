package Problems;//FIND THE UNIQUE NUMBER IN AN ARRAY

import java.util.Scanner;

class UniqueNumber{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
         System.out.print("ENTER THE SIZE OF AN ARRAY: ");

        int n = sc.nextInt();
        int[] arr= new int[n];

        System.out.print("ENTER THE ELEMENTS OF AN ARRAY: ");
       for( int i= 0; i<arr.length; i++)
       arr[i]  = sc.nextInt();

       for( int i= 0; i<n; i++){
           for(int j= i+1; j<n; j++){

               if(arr[i]==arr[j]){
                    arr[i] = -1;
                   arr [j] = -1;
               }

           }
       }
       for(int i=0; i<n; i++)
       if(arr[i] != -1)
       System.out.println ("THIS IS UNIQUE NUMBER: " +arr[i]);


    }
}