// Calculate Power(x, n) using Half Power

import java.util.Scanner;

class power1{
    
    static int pow(int n, int x ){
        // Base Case
        if(x==0) return 1;
        
        int halfAns = pow(n, x/2);
        
        if(x%2==0){    // EVEN
         return  halfAns * halfAns;
        }
        else{          // ODD (else optional hota hai iske bina bhi ye line chal sakti hai)
            return  n * halfAns * halfAns;
        }
        
       
        
    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter The Number: ");
        
        int n = sc.nextInt();
        
        System.out.print("Enter The Power: ");
        
        int x = sc.nextInt();
        
        
        System.out.print(pow(n, x));
        
        
        
    }
}