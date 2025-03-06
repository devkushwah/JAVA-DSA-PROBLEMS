package String.StringBuilder;
import java.util.Scanner;

public class AddTwoStrings {

    public static String addStrings(String num1, String num2) {


        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {

            // yaha par hum dono strings ke last se start kar rahe hai aur ek ek digit ko add kar rahe hai aur carry
            // ko bhi add kar rahe hai agar carry hai to usko bhi add kar rahe hai aur carry ko update kar rahe hai
            // sum/10 se aur sum%10 se hum string me append kar rahe hai  aur fir reverse kar rahe hai kyuki humne
            // last se start kiya tha to reverse karne par sahi result milega
            /*
              Example: num1 = "456", num2 = "77"
                 i = 2, j = 1
                sum = carry + num1[2] + num2[1]
                sum = 0 + 6 + 7 = 13
                sb.append(13 % 10) = sb.append(3)
                carry = 13 / 10 = 1
                Result so far: "3"
            **/
            int sum = carry;
            // subtracting '0' to get the integer value of the character
            // aur hum yaha chatAt(i--) isliye kar rahe hai kyoki hum last se start kar rahe hai aur fir reverse kar
            // rahe hai, pehle hum sum krenge fir i-- hoga wohi post decrement hai if() ka hee part hai ki pehele
            // kaam karaao fir i-- krdo
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            // yaha sum%10 karenge kyuki hume last digit chahiye aur fir carry update krenge sum/10 se
            sb.append(sum % 10);
            carry = sum / 10;
        }

        // reverse the string to get the correct result
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter first number: ");
        String num1 = sc.next();

        System.out.print("Enter second number: ");
        String num2 = sc.next();

        // Creating object of Solution class


        // Calling the function and printing result
        String result = addStrings(num1, num2);
        System.out.println("Sum: " + result);

        sc.close();

    }
}