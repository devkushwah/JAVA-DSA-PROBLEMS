package String;

public class intToRoman {
    public static String intToRoman(int num) {
        // ye humne values dedi aur loop chalake sab values se divide denge, aur jo divide krde uska symbol jod denge
        int[] value =     {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // ye humne result naam ki string bana li jo humara output rahega, aur stringBuilder() good choice
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                result.append(symbol[i]);
//                num -= value[i];
                num = num - value[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        int testNum = 33;  // Example number to test
        String roman = intToRoman(testNum);

        System.out.println("Integer: " + testNum + " => Roman: " + roman);
    }
}
