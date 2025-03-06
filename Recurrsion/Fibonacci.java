// Print Fibonaccci number

import java.util.Scanner;

class  Fibonacci{
//Print fibanacci numbers till nth number, not till n number
    static int fibo(int n ){
        // Base Case
        if(n<=1)  // yeh last tak poch jaay
        return n;

        //Recursive Work
        int prev = fibo(n-1);
        int prevPrev = fibo(n-2);

         //Self Work
        return prev + prevPrev;

    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);

        System.out.print("Enter The Number: ");

        int x = sc.nextInt();

        for(int i =0; i<=x; i++) {
            System.out.print( " " +fibo(i));
        }




    }
}