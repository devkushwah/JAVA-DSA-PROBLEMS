package Sorting.ComparisonTypeSorting;

public class BubbleSort {
    public static void bubbleSort(int[] a){
        int n = a.length;

        for (int i=0; i<n-1; i++){
            // (n-1) isliye for e.g. agar 5 element hai to 4 baar round chalega tab jaake sorting complete hogi...4 baar krne par isliye 5th ko sort krne ki jrurt nhi

            boolean flag = false; // ye bataagya ki koi swapping hui hai ya nahi(abhi filhal to nhi hui)
            for (int j=0; j<n-i-1; j++){
                // har round ke baad last me sabse bda elem. apni jahag par self aa jata hai to iteration me usko kyo
                // lo...isliye [(n-i-1) = (n - (i+1))] karenge jisse iteration chhota hota jaayga
                if (a[j]>a[j+1]){
                    // swap
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true; // some swap has happened
                }
            }
            if(flag == false){ // agar koi swapping nhi hui to iska mtbl aange sab sort hai isse code optimization
                // acha ho jaayga
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {4, 6, 55, 2, 9};
        bubbleSort(a);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}
