package Sorting.ComparisonTypeSorting;

public class QuickSort {
    /* Steps to approach logics=:-
    1. Humne pivot ko first position par rakha hai aur fir pivot ab hum partition method ka use karke pivot ke bich
    me laaynge aur usko sahi jagah par rakhenge aur uss jahgah ka naam hai..(Partion index)
    2.Fir pivot ke Left me pivot se saare chhote aur Right me pivot se saare bade karne hai...aur iss poori process ko
    kehte hai(QuickSort) ab uske do partition ho chuke hai => [left] [pivot] [right]
    3. Ab left partion ke sath bhi same (QuickSort) karna hai
    4. Aur right partion ke sath bhi same (QuickSort) karna hai
     */

    static void displayArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // main kaam yha se hai
    static int partition(int[] arr, int st, int end) {
        //1. First task

        int pivot = arr[st];  // hum kisiko bhi chun sakte hai, par humne first elem. ko pivot elem. chuna hai
        int count = 0; // ye ginega ki kitne chhote hai first elem.(Pivot) ke baad
        for (int i = st + 1; i <= end; i++) {
            if (arr[i] <= pivot) count++;  // arr[i] starting se aange badhega aur dhekega ki pivot se chhote kitne hai
        }
        int pivotIdx = st + count;  // ab tumne dhek liya ki pivot se kitne chhote hai...ab tumko pta chal gaya ki
        // pivot ki real postion kya hai..joki hai => [first elem. ka index + count = pivot ka sahi index(position)]

        swap(arr, st, pivotIdx); // ab tuko pivot ki coorect postion pta chal gai hai to...fir Swap kardo first
        // elem. ko jo humne pivot mana tha uski correct position par jo abhi [st + count]  krke nikaali


        //2. Second Task
        int i = st, j = end;
        while (i < pivotIdx && j > pivotIdx) {   // ye condition taaki galti se i ya j me se koi bhi increase aur
            // decrease hote hote pivot bababar aa jaay to hume rok dena hai warna galti se wo sahi waale ko swap
            // krdenge
            while (arr[i] <= pivot) i++; // pivot se chhote ya bababar elem. ko hum pivot ke left me rakhenge..
            // .jab tak pivot se chhota elem. milta jaa raha hai i++ krte jaao bada aane par ruk jaao

            while (arr[j] > pivot) j--;  // pivot se bade elem. ko pivot ke right me rakh do....jab tak
            // pivot se bada elem.  milta jaa raha hai j-- krte jaao chhota elem. aane par ruk jaao
            if (i < pivotIdx && j > pivotIdx) {
                swap(arr, i, j); // agar i aur j galti se cross ho jaay to unko swap nahi karna hai..aur wo cross
                // tabhi honge jab i ka index pivot ke index se bada ho jaay aur j ka index pivot ke index se
                // chhhota ho jaay..agar aisA  ho jaay to swapping nahi karna isse sorted left, right elements badal
                // jaaynge
                i++;
                j--;
            }
        }
        return pivotIdx;   // yehi wo pi hai
    }

    // program yha se start hai
    static void quickSort(int[] arr, int st, int end) {
        if (st >= end) return;  //ya to phele se sort ho ya to dono elem. barabar ho
        int pi = partition(arr, st, end); // ye partition method partition karke pivot ko bich me laayga jisko hum
        // bolenge 'partition index' aur partition method pivot ke left me saare chhote aur Right me saare bde krdega
        quickSort(arr, st, pi - 1);  // same for Left part partition of pivot
        quickSort(arr, pi + 1, end);  // same for Right part partition of pivot
    }

    public static void main(String[] args) {
        int[] arr = {7, 11, 9, 13, 8};
        System.out.println("Array before sorting");
        displayArr(arr);
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Array after sorting");
        displayArr(arr);
    }
}

