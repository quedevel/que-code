package leetcode.easy;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int cnt = 0;
        for (int digit : digits) {
            if (digit == 9) cnt++;
        }
        if (digits.length == cnt){
            int[] iArr = new int[digits.length+1];
            iArr[0] = 1;
            return iArr;
        }
        int lastIndex = digits.length-1;
        while(digits[lastIndex] == 9){
            digits[lastIndex] = 0;
            lastIndex--;
        }
        digits[lastIndex] = digits[lastIndex]+1;
        return digits;
    }

    public static void main(String[] args) {
        int[] iArr = {7,2,8,5,0,9,1,2,9};
        System.out.println(Arrays.toString(plusOne(iArr)));
    }
}
