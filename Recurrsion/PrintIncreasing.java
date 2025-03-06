// Print Numbers 1 to n

import java.util.Scanner;

class PrintIncreasing{
    
    static void pd(int n ){
        // Base Case
        if(n==1){
            System.out.println(1);
            return ;
        }
        
        //Recursive Work
        pd(n-1);
        
        //Self Work
        System.out.println(n);
        
    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter The Number: ");
        
        int x = sc.nextInt();
        
        pd(x);
        
        
        
    }
}