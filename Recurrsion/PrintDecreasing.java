// Print Numbers n to 1

import java.util.Scanner;

class PrintDecreasing{
    
    static void pd(int n ){
        // Base Case
        if(n==1){
            System.out.print(1);
            return ;
        }
        
        //Self Work
        System.out.println(n);
        
        //Recursive Work
        pd(n-1);
        
    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter The Number: ");
        
        int x = sc.nextInt();
        
        pd(x);
        
        
        
    }
}