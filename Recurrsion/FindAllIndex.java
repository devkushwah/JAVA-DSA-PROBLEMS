// findfirstindex --> return  all index of target present in array, otherwise return -1

import java.util.Scanner;
class FindAllIndex{
    
    static int findIndex(int[] arr,int target, int idx) { 
        
        //Base Case                                 // if(idx = arr.length) return 0;
        if(idx>=arr.length) return -1;
        
       //Self work - (PHELE INDEX KO CHECK KRO NHAI TO AANGE BHADHO)
       if(arr[idx]==target) 
       System.out.print(" " +idx);
       
       
       // (AGAR PEHLE NAHI MILA TO RECURSION SE BOLO WO AANGE  DHKKE BTAYGA)
       //Recurive work- (YE KAAM DEGA NEECHE SE UPR , FIR KAAM HOKAR NEECHE AAYGA, FIR KAAM CHECK HOGA)
       
      return findIndex(arr, target, idx+1);  
     
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
          findIndex(arr, target, 0);  // isme 0 ka bht mehtb hai
    }
}