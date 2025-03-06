// Calculate Power(x, n) 

import java.util.Scanner;

class power{
    
    static int pow(int n, int x ){
        // Base Case
        if(x==0) return 1;
       
      int ans = n * pow(n, x-1);
      return ans;
        
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