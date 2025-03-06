// Remove Character occurence in String

import java.util.Scanner;
class RemoveCharacter{
    
    static String Remove(String s, int idx) { 
        
        //Base Case                                 
        if(idx==s.length()) return " ";
       
        // Recursive-work 
        String smallAns = Remove(s, idx+1);
        
        char currChar = s.charAt(idx);
        
        //Self-work
        if(currChar!= 'a'){
            return  currChar + smallAns;
        }
        else{
            return smallAns;
        }
     
    } 

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // System.out.print("Enter size of an String: ");
        // String n  = sc.nextLine();
        
        
        System.out.print("Enter Characters of String: ");
            String x = sc.nextLine();
        
       
          System.out.print(Remove(x, 0));
    }
}