package Problems;

public class SecondOrderElements {
        public static int[] getSecondOrderElements(int n, int[] a) {
            return findSecmaxAndmin(n, a);
        }

        public static int[] findSecmaxAndmin(int n, int[] a) {
            int mx = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (a[i] > mx) {
                    secondMax = mx;
                    mx = a[i];
                } else if (a[i] > secondMax && a[i] != mx) {
                    secondMax = a[i];
                }

                if (a[i] < min) {
                    secondMin = min;
                    min = a[i];
                } else if (a[i] < secondMin && a[i] != min) {
                    secondMin = a[i];
                }
            }

            return new int[]{secondMax, secondMin};
        }

        public static void main(String[] args) {
            int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
            int n = arr.length;
            int[] result = getSecondOrderElements(n, arr);
            System.out.println("Second Maximum: " + result[0]);
            System.out.println("Second Minimum: " + result[1]);
        }
    }


