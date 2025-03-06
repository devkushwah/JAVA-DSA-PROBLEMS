package Problems;// Difference between maximum value And minimum value

import java.util.Scanner;

class SpanArray{

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of array: ");
        int n= sc.nextInt();

        int[] arr= new int [n];

        System.out.print("Enter the Numbers of array: ");
        for(int i=0; i<arr.length; i++)
            arr[i]= sc.nextInt();

        int max = arr[0];
        int min= arr[0];

        for(int i=1; i<arr.length; i++){

            if(max<arr[i])
                max = arr[i];

            if(min>arr[i])
                min = arr[i];


        }
        int span= max-min;
        System.out.println(span);

    }
}