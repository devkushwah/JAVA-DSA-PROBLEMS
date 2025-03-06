package Stack.ConceptsAndMethods;

import java.util.Stack;

public class RemoveConsecutiveSameElement {
    public static int[] remove(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i<n; i++){
            // satck khaali ho...... yato stack ka top element array ke element se match na ho to push krdo uss element
            // ko stack me
            // step1 = stack khaali push(1)
            // step2 = 1 != 2 push(2)
            if (st.size() == 0 || st.peek() != arr[i]) // 1 != 2
                st.push(arr[i]); // push(2)

            // agar stack ka element array ke element se match ho gya to pop karna hai
           else if (st.peek() == arr[i]){
                // sabse phele wo nya element stack me daalegga
                //Condition1:
                // agar last element hee same mil jaay to delete krdo aange bhadne ki kya jarurat
                //Condition2:
                // agar stack ka element array ke ele. se match ho jaay aur array ka next ele. bhi same ho to kuch push na karo chhod hee do usko loop chalne do
                // aur agar array ka ele. uske next ele. se match nhi huya to pop krdo jo stack me pehele daala tha usko pop krdo
                if( (i ==n-1) || arr[i] != arr[i+1])
                    st.pop();
            }
        }
        int[] res = new int [st.size()];
        int m = res.length;
        for (int i = m-1; i>=0; i--){
            res[i] = st.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1 ,2,2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2};
        int[] res = remove(arr);
        int n = res.length;
        for (int i = 0; i<n; i++){
            System.out.print(res[i] + " ");
        }

    }
}
