// Ye GFG ka problem hai
// concept:- ye stock isse phle kab high tha or kitni baar high reh chuka hai
// based on:- {pop() -> ans(span) -> push()}
package Stack.LeetcodeProblems;
import java.util.Stack;
public class StockSpan {

        public static int[] calculateSpan(int[] prices) {
            //isme sirf array ke index store honge stack me
            int n = prices.length;
            int[] span = new int[n];
            Stack<Integer> stack = new Stack<>();

            // Pehle din ka span 1 hoga kyoki usse pehele koi chhote stock hoga hee nhi
            span[0] = 1;
            stack.push(0);   // ye apn ne stack me index number daal diA first stock ka

            // Calculate span for rest of the days


            for (int i = 1; i < n; i++) {
                /*
                 sabse pehle check karo ki next price jo push hone waala hai, current price se bada hai ya nahi..agar hai to  fir pop() karate jaao chhote waalo ko
                 */
                while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                    stack.pop();  //1. pop() phla kaam
                }

                /*
                 For stack.Empty() condition:-
                  tum pop karate jaaoge...lekin pop ke baad agar stack khaali ho gya to tumko push hone waale price
                  ko ek span se badhana hai...it mean (phele check pop ki condition) (1.agar aisa mil jaay jo pop kare
                  aur
                  stack khaali ho jaay) to uss (2.price ko ek se badha kar ek se) usko stack me (3.push kardo)

                  For Not Empty Stack:-
                  aange badhte time agar koi chhota price waala mil jaay to wo bde price ko pop nhi kara paayga...
                  .jisse stack khaali nhi hoga.....to uss chhote price ka span hoga:-
                  chhota ka index - current bade ka index.
                 */
                //span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
                if(stack.isEmpty()){
                    span[i] = i + 1;
                }

                else {
                    span[i] = i - stack.peek();
                }

                /* bhaai current index chhota ho ya bada push to dono case me ho raha hai isliye bahar hee push
                 likhenge mtlb push to karna hee hee hai chhota ho ya bada entry sabki barabar krni hai*/
                stack.push(i); // NOTE:- Hum index hee push kar rahe hai bss
            }

            return span;
        }

        public static void main(String[] args) {
            int[] prices = {50, 60,70,55,58,90,60};
            int[] span = calculateSpan(prices);
            for (int i=0; i<prices.length; i++){
                System.out.print(prices[i] + " ");
            }
            System.out.println();
            for (int s : span) {
                System.out.print(s + " ");
            }
        }
    }



