// Find GCD(Greatest Common Divisor)

import java.util.Scanner;

class GreatestCommonDivisor1{
    
    static int gcd(int x, int y){
        
        while(x%y!=0){
            
            int remainder = x%y;
            x = y;
            y = remainder;
        }
        return y;
    }
    
    
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("ENTER TWO NUMBERS: ");
        
        int x = sc.nextInt();
        
         int y = sc.nextInt();
         
         
         System.out.print("gcd is: "+gcd(x, y));
    }
}