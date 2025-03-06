// Print the Sum of  values in an Array without traverse in loop

import java.util.Scanner;
class printSumArray{
    
    static int printSumArray(int[] arr, int idx) { 
        
        //Base Case
        if(idx==arr.length-1) return arr[idx];
        
       //Recursive work
       int smallAns = printSumArray(arr, idx+1);
       
       //Self work
       return smallAns + arr[idx];
    } 
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of an Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.print("Enter values of an array: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
       System.out.print("Sum is: " +printSumArray(arr, 0));
    }
}