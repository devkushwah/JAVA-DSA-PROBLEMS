// Print all the values in an array without traverse in loop

import java.util.Scanner;
class printArray1{
    
    static void printArray(int[] arr, int idx) { // {1, 2,  3, 4, 5}
        
        //Base Case
        if(idx==arr.length) return;
        
       //Self Work 
      System.out.print( " "+arr[idx]);  // arr[idx] = { 1 }
      
      // Recursive work        
       printArray(arr, idx+1);  // { 2, 3, 4, 5}
                               //(idx)= isko jo index diya jata hai, ye wha se end tak sab print kar deta hai
        
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
       printArray(arr, 0); 
    }
}