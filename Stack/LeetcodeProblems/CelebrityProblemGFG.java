package Stack.LeetcodeProblems;
// bas logic dhko leetcode pr hee kiya tha full code to chapGpt ne likha hai
import java.util.*;
public class CelebrityProblemGFG {

    public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t > 0) {
                int N = sc.nextInt();
                int M[][] = new int[N][N];
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        M[i][j] = sc.nextInt();
                    }
                }
                System.out.println(new Solution().celebrity(M, N));
                t--;
            }
            sc.close();
        }
    }

    class Solution {
        //Function to find if there is a celebrity in the party or not.
        int celebrity(int M[][], int n) {
            Stack<Integer> st = new Stack<>();
            // Push all people onto the stack where n is number of people.
            for(int i = 0; i < n; i++) {
                st.push(i);
            }
            // Eliminate non-celebrities by comparing pairs of people.
            while(st.size() > 1) {
                int v1 = st.pop();  // agar ye v1 aur v2 koi potential candidet nhi hai to inko pop....aur stack ke
                // neeche waalo ko v1 aur v2 banaao fir check karo
                int v2 = st.pop();
                if(M[v1][v2] == 0) {   // shayad v1 celebrity ho, aur v2 na ho...mtlb v1-> v2 ko nhi jaanta par v2 ->v1
                    // ko jnta hai to v1 ko push krdo
                    st.push(v1);

                } else if(M[v2][v1] == 0) {
                    // shayad v2 celebrity ho, aur v1 na ho...mtlb v2-> v1 ko nhi jaanta par v1-> v2
                    // ko jnta hai to v2 ko push krdo
                    st.push(v2);
                }
            }
            if(st.size() == 0) {
                // No potential celebrity found.
                return -1;
            }
            int potential = st.pop();
            // Check if the potential celebrity knows nobody and everybody knows the potential celebrity.
            for(int j = 0; j < n; j++) {
                //ye humne row check krli...kyoki row to zero honi chaiye apna potential candidet kisiko naa jaane
                if(M[potential][j] == 1) {
                    // Potential celebrity knows somebody, hence not a celebrity....
                    return -1;
                }
            }
            for(int i = 0; i < n; i++) {
                if(i == potential) {  // ye beech ke coloumn ka hai jisme sab 1 hone chaiye humare potential candidet
                    // ko sab jaane..par beech ka 0 hona cahiye wo khudko hee kaise jaanega
                    continue;
                }
                if(M[i][potential] == 0) {
                    // ye beech ke coloumn ka hai jisme sab 1 hone chaiye humare potential candidet ko sab jaane..
                    return -1;
                }
            }
            // Potential celebrity found.
            return potential;
        }
    }


