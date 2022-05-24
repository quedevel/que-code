package leetcode.easy;

import java.math.BigInteger;

public class AddBinary {
    public static String addBinary(String a, String b) {
        BigInteger bigIntegerA = new BigInteger(a, 2);
        BigInteger bigIntegerB = new BigInteger(b, 2);
        return bigIntegerA.add(bigIntegerB).toString(2);
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "1";
        System.out.println(addBinary(a,b));
    }
}
