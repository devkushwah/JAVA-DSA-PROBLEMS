package Stack.ConceptsAndMethods;
import java.util.*;

//Without using extra space using only stack isko without space isliye bol rahe hai kyoki apn loop ka use nhi kar
// rahe  apn stack ka use kar rahe hai
public class RemoveGreaterElement_Without_Using_Extra_Space {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int arr[] = {1,3,2,1,8,6,3,4};
        int n = arr.length;
        int res[] = new int[n];

        //step1:
        //last element ka koi greater element nahi hoga isliye usko pehle hee -1 dedo
        //last element ko stack me daal do kyoki hum peeche se hee to compare karenge
        res[n-1] = -1;
        st.push(arr[n-1]);

        //step2:
        //compare karne ke liye peeche se (n-2) ele. se chalenge kyoki (n-1) elem. ka koi nxt grt nhi hoga
        for (int i=n-2; i>=0; i--){
            //1. Agar stack ka top elem. chhota hua array ke last elem. se to pop() karte jaana hai
            //2. lekin stack khaali nhi hona chaiye wrna pop() nahi ho paayga
            // "OMG" pehele (!st.empty()) aana tha warna ye  WARNING de raha hai
            while (st.size()>0 && st.peek()<arr[i]){
                st.pop();
            }
            //step3:
            //ab stack ka top elem. chhota hone ke kaaran while loop sabko khaali karte jaayga
            //iska matlb size==0 ho jaayga to uss stack ke elem. ko -(1) dedo
            if ((st.size()==0)) res[i] = -1;

            //step4: according to this:-
            //1. Stack is not empty.
            //2. stack ka top elem. array ke last elem. se bada hai.
            else res[i] = st.peek();

            //step5;
            // ye to karte hee rehna hai har time
            st.push(arr[i]);
        }
        for (int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }

    }
}
