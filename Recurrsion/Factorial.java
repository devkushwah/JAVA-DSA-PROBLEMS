

import java.util.Scanner;

class Factorial{
    
    static int  pd(int n ){
        // Base Case
        if(n==0) return 1 ;
        int fact = n * pd(n-1);
        return fact;
        
        // // small problem - recursive Work
        // int fact = pd(n-1);
        
        // // big problem - Self Work
        // int ans = n*fact;
        // return ans;
    }
    

    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter The Number: ");
        
        int x = sc.nextInt();
        
        System.out.print(pd(x));
        
        
        
        
    }
}