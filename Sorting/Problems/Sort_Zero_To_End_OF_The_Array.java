package Sorting.Problems;

public class Sort_Zero_To_End_OF_The_Array {

        public static void bubbleSort(int[] a){
            int n = a.length;

            for (int i=0; i<n-1; i++){
                boolean flag = false;
                for (int j=0; j<n-i-1; j++){

                    if (a[j]==0 && a[j+1] != 0){
                        // swap
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                        flag = true; // some swap has happened
                    }
                }
                if(flag == false){ // agar koi swapping nhi hui to iska mtbl aange sab sort hai
                    return;
                }
            }
        }
        public static void main(String[] args) {
            int[] a = {0,5,0,3,4,2};
            bubbleSort(a);
            for (int i : a){
                System.out.print(i + " ");
            }
        }
    }




