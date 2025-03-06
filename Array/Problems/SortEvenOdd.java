package Problems;//  SORTHING (SABSE PEHLE EVEN THEN ODD)


import java.util.Scanner;

class SortEvenOdd{

    static void swap(int[] arr, int left, int right){
        int temp = arr [left];
        arr [left] = arr [right];
        arr [right]  = temp;

        return;
    }

 static void sortEvenAndOdd(int[] arr){

     int n = arr.length;
     int left = 0, right = n-1;

     while(left<right){
         if(arr[left]%2==1 && arr[right]%2==0){
             swap(arr, left, right);
             left++;
             right--;
         }

         if(arr[left]%2==0){
             left++;
         }

         if(arr[right]%2==1){
             right--;

         }
     }

     return;
 }



    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER SIZE: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("ENTER ELEMENTS: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sortEvenAndOdd(arr);

        for(int i  = 0; i<n; i++){
            System.out.print( " " +arr[i]);
        }
    }

}


