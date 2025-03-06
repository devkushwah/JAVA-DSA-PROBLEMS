package String;
import java.util.*;

public class Roman_To_Integer {

    // Method1:
    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanMap.get(s.charAt(i));

            if (currValue < prevValue) {
                sum -= currValue; // Subtract if smaller than previous
            } else {
                sum += currValue; // Otherwise, add
            }
            prevValue = currValue;
        }
        return sum;
    }

    public int num(char ch) { // Fix 1: Return type 'int' kar diya
        if (ch == 'I') return 1;
        else if (ch == 'V') return 5;
        else if (ch == 'X') return 10;
        else if (ch == 'L') return 50;
        else if (ch == 'C') return 100;
        else if (ch == 'D') return 500;
        else return 1000;
    }

    public int romanToInt2(String s) {
        int sum = 0, index = 0;
        int n = s.length();

        while (index < n - 1) {
            if (num(s.charAt(index)) < num(s.charAt(index + 1))) { // Fix 2: Condition ko sahi likha
                sum -= num(s.charAt(index));
            } else {
                sum += num(s.charAt(index));
            }
            index++;
        }
        sum += num(s.charAt(n - 1));
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a Roman numeral: ");
        String roman = sc.nextLine();

        // Creating object of Solution class and converting to integer

        int result = romanToInt(roman);

        // Printing result
        System.out.println("Integer equivalent: " + result);

        sc.close();
    }
}
