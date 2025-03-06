// Print Multiples of Number

import java.util.Scanner;

class printmultiples{
    
    static void printmultiples(int n, int k ){
        
        // Base Case
        if(k==0) return ;
        
        //recusive work
        printmultiples(n, k-1 );    // 5 10 15 
        
        //self work
        System.out.print( " "+n * k);    //20
        
       
        
    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter The Number: ");
        
        int n = sc.nextInt();
        
        System.out.print("Enter The Multiple's Number: ");
        
        int x = sc.nextInt();
        
        
        printmultiples(n, x);
        
        
        
    }
}