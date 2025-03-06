package Problems;
// sort zeroes and ones starting me zeroes fir ones

import java.util.Scanner;

public class sortZeroesAndOnes {


    static int[] sortZeroesAndOnes(int[] arr){
            int n = arr.length;
            int left = 0, right = n-1;
            int zeroes = 0;

            for(int i = 0; i<n; i++){
                if(arr[i]==0){
                    zeroes++;
                }
            }
            for(int i= 0; i<n; i++){        // iska matlb hai wo utne zero bnaayga jitne array me zeroes lie krte ho
                if(i<zeroes){
                    arr[i] = 0;
                }
                else{
                    arr[i] = 1;
                }
            }
            return arr;

        }
        public static void main (String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("ENTER THE SIZE: ");
            int n = sc.nextInt();

            int[] arr = new int[n];

            System.out.print("ENTER ELEMENTS: ");

            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            // sortZeroesAndOnes(arr);

            int[] sorting = sortZeroesAndOnes(arr); // fixed method call

            for( int j = 0; j<n; j++) {
                System.out.print( " " + sorting[j] ); // fixed array name
            }

        }

}
