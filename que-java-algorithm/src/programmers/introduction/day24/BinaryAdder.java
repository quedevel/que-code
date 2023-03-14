package programmers.introduction.day24;

public class BinaryAdder {
    public static void main(String[] args) {
        BinaryAdder binaryAdder = new BinaryAdder();
        System.out.println(binaryAdder.solution("10","11"));
        System.out.println(binaryAdder.solution("1001","1111"));
    }
    public String solution(String bin1, String bin2) {
        int bin1val = Integer.parseUnsignedInt(bin1, 2);
        int bin2val = Integer.parseUnsignedInt(bin2, 2);
        return Integer.toBinaryString(bin1val+bin2val);
    }
}
