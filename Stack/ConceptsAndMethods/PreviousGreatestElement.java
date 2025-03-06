package Stack.ConceptsAndMethods;

import java.util.Stack;

class PreviousGreatestElement {

    public static int[] prevGreaterElements(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st  = new Stack<>();
        st.push(arr[0]);
        res[0] = -1;

        for(int i=1; i<n; i++){
            while(st.size() > 0 && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                res[i] =-1;
            }
            else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }

    return res;
    }
    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        int res[] = prevGreaterElements(arr);

        System.out.println("Original Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nPrevious Greater Elements:");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
