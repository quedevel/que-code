package programmers.level2;

import java.util.Arrays;

public class BinaryConversionIterator {
    public static void main(String[] args) {
        BinaryConversionIterator binaryConversionIterator = new BinaryConversionIterator();
        System.out.println(Arrays.toString(binaryConversionIterator.solution("110010101001")));
        System.out.println(Arrays.toString(binaryConversionIterator.solution("01110")));
        System.out.println(Arrays.toString(binaryConversionIterator.solution("1111111")));
    }
    public int[] solution(String s) {
        int convertCount = 0;
        int zeroCount = 0;
        while(!s.equals("1")){
            for (int i = 0; i < s.length(); i++) {
                if ('0' == s.charAt(i)) zeroCount++;
            }
            s = Integer.toBinaryString(s.replace("0", "").length());
            convertCount++;
        }
        return new int[]{convertCount, zeroCount};
    }
}
