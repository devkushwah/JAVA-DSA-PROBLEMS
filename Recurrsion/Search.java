// Print Check Whether "x" is present or Not in Array

import java.util.Scanner;
class Search{
    
    static boolean Search(int[] arr,int target, int idx) { 
        
        //Base Case                                 // if(idx = arr.length) return 0;
        if(idx>=arr.length) return false;
        
       //Self work - (PHELE INDEX KO CHECK KRO NHAI TO AANGE BHADHO)
       if(arr[idx]==target) return true;
       
       
       // (AGAR PEHLE NAHI MILA TO RECURSION SE BOLO WO AANGE  DHKKE BTAYGA)
       //Recurive work- (YE KAAM DEGA NEECHE SE UPR , FIR KAAM HOKAR NEECHE AAYGA, FIR KAAM CHECK HOGA)
       
      return Search(arr, target, idx+1);   // ye boolean method hai isliye  ya to true return krga ya fir false
       
    //   if(Search(arr, target, idx) /* == true*/) return true;
    //   else return false;
    } 

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of an Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.print("Enter values of an array: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target: ");
            
            int target = sc.nextInt();
            
            if(Search(arr, target, 0)/* ==true */) {  // Yadi LINE No.18 Se TRUE boolava a gya to Ye TRUE
                System.out.print("Found");
            }
            else{
                System.out.print("Not-Found");       // YAdi upr se bulava nhi aaya to YE chalega
            }
    }
}