// Given an Integer, Find out the Sum of its digits using Recursion

import java.util.Scanner;

class SumOfDigits{
    
    static int sod(int n ){
        // Base Case
        if(n>=0 && n<=9)
        return n;
       
      int ans =  sod(n/10) + n%10;
      return ans;
        
    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter The Number: ");
        
        int x = sc.nextInt();
        
        
        System.out.print(sod(x));
        
        
        
    }
}