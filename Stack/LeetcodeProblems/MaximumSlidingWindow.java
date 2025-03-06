package Stack.LeetcodeProblems;
import java.util.Stack;
public class MaximumSlidingWindow {
// Suggestion:- agar code nhi samajh aa rha hai to copy me check mst dry run hai
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            //int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
            /*
             for example k = 3, you can see last me {3,6,7} window ban raha hai...par uske aange {6,7} nhi ban paayge
             inn dono ko minus krdo - that's why:-
             [n - k +1 ] = n - (k - 1)
             for example k = 4, you can see last me {5, 3, 6, 7} window ban raha hai....par uske aange {3, 6, 7}} nhi
              ban paayga inn teeno ko minus krdo
             */
            int[] ans = new int[n - k + 1]; // ye answer array hai jo chaiya humko jiska size [n - k + 1] hai

            int z = 0;  // ye answer array ka index hai
            Stack<Integer> st = new Stack<>();
            int[] nge = new int[n];

            st.push(n-1);
            nge[n-1] = n;
            for(int i=n-2; i>=0; i--){
                while(st.size()>0 && nums[i]>=nums[st.peek()]) st.pop();
                if(st.size()==0) nge[i]= n;  //n isliye -1 isliye nhi kyoki tum jante ho jis elem. ka nge bagar hota
                    // hai wo max hota hai window me....par jo sbse bada hai poore array me uska to  nge koi hoga
                    //hee nhi uska apn -1 to rakh nhi sakte ab wo sbse bada hai to uska nge bahar hona
                    // chaiye na isliye humne sbse bada number lia hai aakhri ka arr.length.
                else nge[i] = st.peek();
                st.push(i);
            }

            int j = 0;
            for(int i=0; i<n-k+1; i++){  // ye check to (1, 3, -1, -3, 5, 3) yahi tak krega naki (6, 7) kyoki 2 ki
                // window to banegi nhi to usme answer kaise milega

                //NOTE:- ( 'J' KI BAHAR WAALI CONDITION)
                if(j>=i+k) {   // sbse phle dhko window me kis element ka nge bahar hai...jis elem. ka nge bahar hai
                    // 'j' ko usi bahar nge elem pr point krdo...
                    //aur agar 'i' next iterate karne par bhi 'j' window ke bahar hai to usko 'i' ke place pr point
                    // krdo....aur agar 'j' window ke andar hai to wo window ka max hai aur uska nge bahar hoga
                    j=i;
                }
                int max = nums[j];    // bahar ke liye...agar bahar hai to jo ko max bana do

                //NOTE:- ( 'J' KI ANDAR WAALI CONDITION)
                while(j<i+k){
                    max = nums[j];   // andar ke liye...agar j andar hai to check kro poori window kis elem ka nge bahar
                    // hai
                    j = nge[j];      // iterate karne par bhi j anadr hai to j hee max hua usse phle sab chhote huye
                }

                // dono condition se max milega aur ans array mr dalega
                ans[z++] = max;
            }
            return ans;
        }

        public static void main(String[] args) {
            
            int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
            int k = 3;
            int[] result = maxSlidingWindow(nums, k);
            // Output: [3, 3, 5, 5, 6, 7]
            System.out.println("Maximum elements in sliding windows of size " + k + ":");
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }


