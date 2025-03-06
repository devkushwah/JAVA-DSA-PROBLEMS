package Sorting.NonComparisonTypeSorting;

public class CountSort {
        static int findMax(int[] arr){
            int mx = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > mx){
                    mx = arr[i];
                }
            }
            return mx;
        }
        static void basicCountSort(int[] arr){
            //This is not stable sort
            int max = findMax(arr); // Find the largest element of the arr
            int[] count = new int[max+1]; // [max+1] isliye kara taaki hum 5 ko bhi include kar sake aur
            // ye size = 6 ka khaali count[] array hai jisme kuch nahi hai bss index hai isme [0,1,2,3,4,5]

            for(int i = 0; i < arr.length; i++){  //arr[] = {1, 4, 5, 2, 2, 5}
                count[arr[i]]++; // jo number = arr[i] ka, count[] me hai uski freq. bhadana hai aur count karna hai ki
                // konsa number kitni baar repeat hua hai...aur sath hee sath me frequency store ho rahi hai count[] me.
                /*
                count of num. = times     (in COUNT[] array)
                count[0] = 0
                count[1] = 1
                count[2] = 2
                count[3] = 0
                count[4] = 1
                count[5] = 2
                 */
            }

            int k = 0;  //bina koi naya array banaay usi array me changes karne ke liye
            for(int i = 0; i < count.length; i++){  // humare count me 6 value store ho chuki hai = {0,1,2,0,1,2} to
                // count ki length hui = 6....isliye 6 baar loop chalega (0 to 5) index ke liye
                for(int j = 0; j < count[i]; j++){  // aur ye unki frequency(count[i]), ki kitni baar uske index
                    // ko arr[] me daalna hai
                    arr[k++] = i;  // jo number jitni baar count[] me hai utni baar uska index arr[] me jaayga
                }
            }
        }
        static void display(int[] a){
            for(int val : a){
                System.out.print(val + " ");
            }
            System.out.println();
        }
        static void countSort(int[] arr){
            //This is stable sort
            int n = arr.length;
            int[] output = new int[n];
            int max = findMax(arr); // Find the largest element of the arr
            int[] count = new int[max+1];
            for(int i = 0; i < arr.length; i++){ //same as basicCountSort()
                count[arr[i]]++;
            }
            // yaha tak sab same tha, but ab ye karna hai:-
            // Make prefix sum array of count array
            for(int i = 1; i < count.length; i++){ // TC -> max
                count[i] = count[i] + count[i-1];   // ye modification ho gai ab count[] me prefixSum ka data hai
            }
            // Find the index of each element in the original array and put it in output  array
            for(int i = n-1; i >= 0; i--){ // TC -> n
                // ye traverse apne main arr[] par kar raha hai
                int idx = count[arr[i]] - 1; // ye hum frequency - 1 karke output[] ke liye index(es) bana raha hai
                output[idx] = arr[i]; //Ab hume index pata chal gaya hai to arr[] me jo hum peeche se traverse kar
                // rahe hai, wo values ek-ek karke iss output[] me iss index par daalna hai
                count[arr[i]]--;  // count[] me prefixsum ka jo data dala hai...jo humne arr[i] ki madat se peeche se
                // uthaya tha usko ek se kam kar dena hai
            }
            // copy all elements of output to arr
            for(int i = 0; i < n; i++){ // TC -> n
                arr[i] = output[i];
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, 4, 5, 2, 2, 5};
            countSort(arr);
//        basicCountSort(arr);
            display(arr);
        }

}
