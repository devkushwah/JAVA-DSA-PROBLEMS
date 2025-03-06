// Reverse Character occurence in String

import java.util.Scanner;
class Reverse{
    
    static String Reverse(String s, int idx) { 
        
        //Base Case                                 
        if(idx==s.length()) return " ";
       
        // Recursive-work 
        String smallAns = Reverse(s, idx+1);
        
        //Self-work
            return smallAns + s.charAt(idx);
     
    } 

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // System.out.print("Enter size of an String: ");
        // String n  = sc.nextLine();
        
        
        System.out.print("Enter Characters of String: ");
            String s = sc.nextLine();
        
       
          System.out.print(Reverse(s, 0));
    }
}