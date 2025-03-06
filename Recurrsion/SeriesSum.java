// Print Sum of series

import java.util.Scanner;

class SeriesSum{
    
    static int  SumSeries(int n){
        
        // Base Case
        if(n==0) return 0 ;
        
      if(n%2==0){
      return SumSeries(n-1) - n;          //EVEN
      }
      
      else{
          return SumSeries(n-1) + n;    //ODD
      }
       
        
    }
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter The Number: ");
        
        int n = sc.nextInt();
        
       
        
        System.out.print(SumSeries(n));
        
        
    }
}