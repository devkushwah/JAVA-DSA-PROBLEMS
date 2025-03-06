// Print the maximum values in an array without traverse in loop

import java.util.Scanner;
class printMaxArray{
    
    static int printMaxArray(int[] arr, int idx) { 
        
        //Base Case
        if(idx==arr.length-1) return arr[idx];
        
       //Recursive work
       int smallAns = printMaxArray(arr, idx+1);
       
       //Self work
       return Math.max(smallAns, arr[idx]);
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
       System.out.print("max number is: " +printMaxArray(arr, 0));
    }
}