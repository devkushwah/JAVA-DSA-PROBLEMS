package Problems;

import java.util.Arrays;

public class ArraysMethodsInJava {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,7,6,4,3,66};
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
