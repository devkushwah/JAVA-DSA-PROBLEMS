// check String is Palindrome or Not

import java.util.Scanner;
class isPalindrome{
    
    static boolean isPalindrome(String s, int l, int r) { 
        
        //Base Case                                 
        if(l>=r) return true;
       
        // Recursive-work 
        return  (s.charAt(l)==s.charAt(r) && isPalindrome(s, l+1, r-1));
        //Self-work
            
     
    } 

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // System.out.print("Enter size of an String: ");
        // String n  = sc.nextLine();
        
        
        System.out.print("Enter Characters of String: ");
            String s = sc.nextLine();
        
       
          System.out.print(isPalindrome(s, 0, s.length()-1));
    }
}