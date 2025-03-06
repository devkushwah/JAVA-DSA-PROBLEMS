package Problems;

import java.util.Scanner;

class OccuranceElement{

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER THE LENGTH OF ARRAY: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("ENTER THE ELEMENTS: ");

        for(int i = 0; i<arr.length; i++ )
        arr[i] = sc.nextInt();

        System.out.print("ENTER THE NUMBER OF COUNT OCCUR: ");
        int x= sc.nextInt();

        int count = 0;


        for(int i = 0; i<arr.length; i++){
        if (arr[i]==x){
            count++;}
        }
        System.out.print("THE NUMBER " +x+ " is Occured " +count+ " times ");



    }
}