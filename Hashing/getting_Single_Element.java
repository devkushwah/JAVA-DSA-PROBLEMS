package Hashing;
import java.util.*;

public class getting_Single_Element {

        public static int getSingleElement(int []arr) {
            //size of the array:

            // Declare the hashmap.
            // And hash the given array:
            HashMap<Integer, Integer> mpp = new HashMap<>();
            for (int j : arr) {
                int value = mpp.getOrDefault(j, 0);
                mpp.put(j, value + 1);
            }

            //Find the single element and return the answer:
            for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
                if (it.getValue() == 1) {
                    return it.getKey();
                }
            }

            //This line will never execute
            //if the array contains a single element.
            return -1;
        }

        public static void main(String[] args) {
            int[] arr = {4, 1, 2, 1, 2};
            int ans = getSingleElement(arr);
            System.out.println("The single element is: " + ans);

        }



}
