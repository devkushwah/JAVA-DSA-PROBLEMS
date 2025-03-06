package Stack.ConceptsAndMethods;
import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // steps = { pop() in the stack, answer wo jo pop krdega, push()(everytime) - Referenec: pep-coding YT}
            // step1: sbse phle arr[n-1] ko -1 dedo kyoki uske baad koi bada to hoga nahi aur usko stack me push kardo.

           /*  step2: reverse me array chalate huye...compare karo arr[i] ko stack waale elem. se jo stack me
           present hoga(top) agar stack me uss arr[i] se koi bhi chhota stack elem. mile to uss stack waale elem. ko  pop()
            krdo jitne bhi elem. ho stack me(tab tak pop karaao jab tak stack khaali na ho jaay)....pop() hona tab
            rukega ya to stack khaali ho jaay ya to stack ke top pr koi bada elem. aa jaay arr[i] se.... aur aakhir me uss
            arr[i] ko bhi push() krdo. */

           /* step3: Agar stack ka top elem. bda hua arr[i] se  to pop() to krna nhi hai... pop() wo kar nhi
           paayga iska mtbl ya to stack khaali hai to res[i] ko -1 dena hai kyoki hum stack ke top elem. ko hee
           res[i] me daalte hai joki khaali hai.... ( ya to  stack ka top elem. bda hai arr[i] se to fir push() karna
            hai aur res[i] me stack ke top  ki value deni hai....)  */

            // Note: res[i] me 2 hee value jaati hai -1 yato stack ka top.... -1 empty hone par aur stack ka top tab
            // daalte hai jab stack ka top bda ho arr[i] se

            // ye arr[i] se sbhi chhote stack ke top elem. ka pop() karte jaayga
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // isme sirf {8, 6, 4} ko hee '-1' mila hai....aur iska logic hai:-
            // agar tum dry run karo to phle 8 (1,2,3) ko pop() krega jisse stack khaali ho jaayga...if waali
            // condition chalegi aur usko '-1' de diya jaayga fir aakhri me 8 ko push() krenge stack me

            if (stack.isEmpty()) {      //res[i] = stack.isEmpty() ? -1 : stack.peek();
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }


            // bhai push to compulsary hai sabhi ke liye chhaye arr[i[ bda ho ya stack ka top
            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 1, 8, 6, 3, 4};
        int res[] = nextGreaterElements(arr);

        System.out.println("Original Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nNext Greater Elements:");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}


// Using Array (Method - 2)

//package Stacks;
// But this method using extra space and its T.c is O(n*n) ans s.c is O(1) due to two loops
//public class NextGreaterElement {
//    public static int[] remove(int[] arr){
//        int n = arr.length;
//        int[] res = new int[n];
//        for (int i=0; i<n; i++){
//            res[i] = -1;
//            for (int j = i+1; j<n; j++){
//                if(arr[j] > arr[i]) {
//                    res[i] = arr[j];
//                    break;
//                }
//            }
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        int arr[] = {1,3,2,1,8,6,3,4};
//        int res[] = remove(arr);
//        for (int i = 0;i<arr.length;i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        for(int i = 0; i<res.length; i++){
//            System.out.print(res[i] + " ");
//        }
//
//    }
//}
