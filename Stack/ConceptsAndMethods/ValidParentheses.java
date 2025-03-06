// ye isBalancedParanthesis ka duplicate hai

package Stack.ConceptsAndMethods;
import java.util.*;
class balancedBrackets {
    public static boolean isBalanced(String str){
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);       // ek ek krke characters ko uthaao
            if(ch == '(')  st.push(ch);    // aur milaao opening bracket ko agar mila yo push() krdo stack me

            else  {// ch == ')'
                if (st.size() == 0) return false;  // agar stack khaali hai to ')' ka koi matlb nhi hoga wo akela
                // hoga wo false hee mana jaayga
                if (st.peek() == '(') st.pop();  // agar stack ke top par'(' hai aur array par ')' aaya hai to..'('
                // ko uda do dono mt rhde do stack me isse pta chlega aakhri me kya bacha
            }
        }
        if(st.size()>0) return false; // agar stack khaali nhi hua push='(' aur pop=')' krke to stack me koisa
            // parenthesis hai
        else return true;  // mtlb khaali to sab sahi
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Paranthesis: ");
        String str = sc.nextLine();
        System.out.println(isBalanced(str));

    }
}
